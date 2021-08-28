package ault.InboxApi.Entities.Entries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntryService {
  private final EntryRepository _entryRepository;

  @Autowired
  public EntryService(EntryRepository entryRepository) {
    this._entryRepository = entryRepository;
  }

  public Optional<Entry> entity(String id) {
    return _entryRepository.findById(id);
  }

  public List<Entry> entries() {
    return _entryRepository.getUnarchivedEntries();
  }

  public long entryCount(String userId, String context) {
    return _entryRepository.countUnarchived(userId, context);
  }

  public String createEntry(CreateEntryRequest request) {
    Entry entry = new Entry(request.content, request.userId, request.context);
    _entryRepository.save(entry);
    return entry.getId();
  }

  public String updateEntry(Entry updatedEntry) {
    System.out.println(updatedEntry);
    _entryRepository.save(updatedEntry);
    return updatedEntry.getId();
  }

  public boolean archiveEntry(String entryId) {
    Entry entry = _entryRepository.findById(entryId).get();
    entry.setArchived(true);
    _entryRepository.save(entry);
    return true;
  }

  public List<Entry> getEntriesByUserAndContext(String userId, String context) {
    System.out.println("In service for entries by user and context");
    return _entryRepository.getCurrentEntries(userId, context);
  }

}
