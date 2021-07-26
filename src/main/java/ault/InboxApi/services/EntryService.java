package ault.InboxApi.services;

import ault.InboxApi.repositories.*;
import ault.InboxApi.models.*;

import org.springframework.beans.factory.annotation.Autowired;
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
    return _entryRepository.findAll();
  }

  public long entryCount() {
    return _entryRepository.count();
  }

  public String updateEntry(Entry updatedEntry) {
    System.out.println(updatedEntry);
    _entryRepository.save(updatedEntry);
    return updatedEntry.getId();
  }

  public List<String> getTags() {
    var entities = entries();
    var result = new ArrayList<String>();
    for (var entity : entities) {
      for (var tag : entity.getTags()) {
        if (!result.contains(tag)) {
          result.add(tag);
        }

      }
    }
    return result;
  }

}
