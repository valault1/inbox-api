package ault.InboxApi.Entities.ListGroups;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class ListGroupController {
  private final ListGroupService _listGroupService;

  @Autowired
  public ListGroupController(ListGroupService listGroupService) {
    this._listGroupService = listGroupService;
  }

  @PutMapping("/listGroup/create")
  public String createEntry(@RequestBody CreateListGroupRequest newListGroupRequest) {
    return _listGroupService.createListGroup(newListGroupRequest);
  }

  @GetMapping("/listGroup/getAll")
  public List<ListGroup> getAllListGroups() {
    return _listGroupService.getAllListGroups();
  }

  @GetMapping("/listGroup/getByUser/{userId}")
  public List<ListGroup> getByUser(@PathVariable("userId") String userId) {
    return _listGroupService.getByUser(userId);
  }

  @GetMapping("/listGroup/getPopulatedListGroupsbyUser/{userId}")
  public List<PopulatedListGroup> getPopulatedListGroupsbyUser(@PathVariable("userId") String userId) {
    return _listGroupService.getPopulatedListGroupsbyUser(userId);
  }



  


}