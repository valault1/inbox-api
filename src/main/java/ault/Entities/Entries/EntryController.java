package ault.Entities.Entries;

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
public class EntryController {
  private final EntryService _entryService;

  @Autowired
  public EntryController(EntryService entryService) {
    this._entryService = entryService;
  }

  @GetMapping("/Entry/Count")
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
    return _entryService.createEntry(newEntryRequest);
  }

  @PostMapping("/Entry")
  public String updateEntry(@RequestBody Entry updatedEntry) {
    System.out.println("Got request to update entity");
    return _entryService.updateEntry(updatedEntry);
  }

  @PostMapping("/Entry/Archive/{entryId}")
  public boolean archiveEntry(@PathVariable("entryId") String entryId) {
    return _entryService.archiveEntry(entryId);
  }

}