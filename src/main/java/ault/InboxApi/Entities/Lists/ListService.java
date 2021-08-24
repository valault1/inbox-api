package ault.InboxApi.Entities.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ListService {
  private final ListRepository _listRepository;

  @Autowired
  public ListService(ListRepository listRepository) {
    this._listRepository = listRepository;
  }

  public String createList(CreateListRequest request) {
    List lg = new List(request.name, request.userId, request.listGroupId);
    _listRepository.save(lg);
    return lg.getId();
  }

  public java.util.List<List> getAllLists() {
    return _listRepository.findAll();
  }

  public java.util.List<List> getListsByGroup(String listGroupName) {
    return _listRepository.getListsByGroup(listGroupName);
  }

  public String updateList(List newList) {
    _listRepository.save(newList);
    return newList.getId();
  }

  public String addListEntry(AddListEntryRequest request) {
    List list = _listRepository.findById(request.listId).get();
    java.util.List<ListEntry> entries = list.getEntries();
    entries.add(new ListEntry(request.entryContent));
    list.setEntries(entries);
    _listRepository.save(list);
    return list.getId();
  }






}
