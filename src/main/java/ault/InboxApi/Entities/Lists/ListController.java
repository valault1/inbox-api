package ault.InboxApi.Entities.Lists;


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
public class ListController {
  private final ListService _listService;

  @Autowired
  public ListController(ListService listService) {
    this._listService = listService;
  }

  @PutMapping("/list/create")
  public String createlist(@RequestBody CreateListRequest newListRequest) {
    return _listService.createList(newListRequest);
  }

  @GetMapping("/list/getAll")
  public java.util.List<List> entries() {
    return _listService.getAllLists();
  }

  @GetMapping("/list/{listGroupId}")
  public java.util.List<List> getListsByGroup(@PathVariable("listGroupId") String listGroupId) {
    return _listService.getListsByGroup(listGroupId);
  }

  @PostMapping("/list/update")
  public String updatelist(@RequestBody List updatedList) {
    return _listService.updateList(updatedList);
  }

  @PostMapping("/list/addListEntry")
  public String addListEntry(@RequestBody AddListEntryRequest request) {
    return _listService.addListEntry(request);
  }

  @PostMapping("/list/updateListEntry")
  public boolean updateListEntry(@RequestBody UpdateListEntryRequest request) {
    return _listService.updateListEntry(request);
  }

  


}