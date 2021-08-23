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

  @PutMapping("/listGroup")
  public String createEntry(@RequestBody CreateListGroupRequest newListGroupRequest) {
    return _listGroupService.createListGroup(newListGroupRequest);
  }

  


}