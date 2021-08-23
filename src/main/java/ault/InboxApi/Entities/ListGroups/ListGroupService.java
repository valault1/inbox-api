package ault.InboxApi.Entities.ListGroups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ListGroupService {
  private final ListGroupRepository _listGroupRepository;

  @Autowired
  public ListGroupService(ListGroupRepository listGroupRepository) {
    this._listGroupRepository = listGroupRepository;
  }

  public String createListGroup(CreateListGroupRequest request) {
    ListGroup lg = new ListGroup(request.name, request.userId);
    _listGroupRepository.save(lg);
    return lg.getId();
  }




}
