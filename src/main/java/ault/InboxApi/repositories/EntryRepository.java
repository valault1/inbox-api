package ault.InboxApi.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ault.Entities.Entries.Entry;

public interface EntryRepository extends MongoRepository<Entry, String> {
  @Query("{archived : false}")
  List<Entry> getUnarchivedEntries();

  @Query(value = "{archived : false}", count = true)
  int countUnarchived();
}
