package ault.InboxApi.Entities.Entries;

import ault.InboxApi.Entities.Entries.Entry;
import ault.InboxApi.models.*;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    return _entryRepository.getEntriesByUserAndContext(userId, context);
  }

}
