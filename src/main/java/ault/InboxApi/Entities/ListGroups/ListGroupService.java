package ault.InboxApi.Entities.ListGroups;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ault.InboxApi.Entities.Lists.ListRepository;
import ault.InboxApi.Entities.Lists.List;
import java.util.ArrayList;

@Service
@Transactional
public class ListGroupService {
  private final ListGroupRepository _listGroupRepository;
  private final ListRepository _listRepository;

  @Autowired
  public ListGroupService(ListGroupRepository listGroupRepository, ListRepository listRepository) {
    this._listGroupRepository = listGroupRepository;
    this._listRepository = listRepository;
  }

  public String createListGroup(CreateListGroupRequest request) {
    ListGroup lg = new ListGroup(request.name, request.userId);
    _listGroupRepository.save(lg);
    return lg.getId();
  }

  public java.util.List<ListGroup> getAllListGroups() {
    return _listGroupRepository.findAll();
  }

  public java.util.List<ListGroup> getByUser(String userId) {
    return _listGroupRepository.getListGroupsByUser(userId);
  }

  public java.util.List<PopulatedListGroup> getPopulatedListGroupsbyUser(String userId) {
    java.util.List<List> lists = _listRepository.getListsByUser(userId);
    java.util.List<PopulatedListGroup> populatedLGs = new ArrayList<PopulatedListGroup>();
    java.util.List<ListGroup> lgs = _listGroupRepository.getListGroupsByUser(userId);

    for (ListGroup lg : lgs) {
      populatedLGs.add(new PopulatedListGroup(lg.getId(), lg.getName(), lg.getUserId()));
    }
    for (List list : lists) {
      for (PopulatedListGroup plg : populatedLGs) {
        if (list.getListGroupId().equals(plg.getId())) {
          // add the list and entries to the populated
          java.util.List<List> listsInPlg = plg.getLists();
          listsInPlg.add(list);
          plg.setLists(listsInPlg);
        }
      }
    }
    return populatedLGs;
  }




}
