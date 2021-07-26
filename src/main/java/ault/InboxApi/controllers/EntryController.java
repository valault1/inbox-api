package ault.InboxApi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ault.InboxApi.models.Entry;
import ault.InboxApi.models.Requests.CreateEntryRequest;
import ault.InboxApi.services.EntryService;

@CrossOrigin(origins = "*")
@RestController
public class EntryController {
  private final EntryService _entryService;

  @Autowired
  public EntryController(EntryService entryService) {
    this._entryService = entryService;
  }

  @GetMapping("/Entry/count")
  public long entityCount() {
    return _entryService.entryCount();
  }

  @GetMapping("/Entry/Entries")
  public List<Entry> projects() {
    System.out.println("Got request for all entities");
    return _entryService.entries();
  }

  @PutMapping("/Entry")
  public String createEntry(@RequestBody CreateEntryRequest newEntryRequest) {
    System.out.println(newEntryRequest);
    return "fake";
  }

  @PostMapping("/Entry")
  public String updateEntry(@RequestBody Entry updatedEntry) {
    System.out.println("Got request to update entity");
    return _entryService.updateEntry(updatedEntry);
  }

  @GetMapping("/Entry/tags")
  public List<String> getTags() {
    System.out.println("Got request for tags!");
    return _entryService.getTags();
  }

}