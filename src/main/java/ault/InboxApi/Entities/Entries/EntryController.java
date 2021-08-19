package ault.InboxApi.Entities.Entries;

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

  @GetMapping("/entry/count/{userId}/{context}")
  public long entityCount(@PathVariable("userId") String userId, @PathVariable("context") String context) {
    return _entryService.entryCount(userId, context);
  }

  @GetMapping("/entry/entries")
  public List<Entry> entries() {
    System.out.println("Got request for all entities");
    return _entryService.entries();
  }

  @GetMapping("/entry/{userId}/{context}")
  public List<Entry> getEntriesByUserAndContext(@PathVariable("userId") String userId,
      @PathVariable("context") String context) {
    System.out.println("Got request for entries by user");
    return _entryService.getEntriesByUserAndContext(userId, context);
  }

  @PutMapping("/entry")
  public String createEntry(@RequestBody CreateEntryRequest newEntryRequest) {
    return _entryService.createEntry(newEntryRequest);
  }

  @PostMapping("/entry")
  public String updateEntry(@RequestBody Entry updatedEntry) {
    System.out.println("Got request to update entity");
    return _entryService.updateEntry(updatedEntry);
  }

  @PostMapping("/entry/archive/{entryId}")
  public boolean archiveEntry(@PathVariable("entryId") String entryId) {
    return _entryService.archiveEntry(entryId);
  }

}