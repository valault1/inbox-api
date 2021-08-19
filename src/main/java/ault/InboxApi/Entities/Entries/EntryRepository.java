package ault.InboxApi.Entities.Entries;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EntryRepository extends MongoRepository<Entry, String> {
  @Query("{archived : false}")
  List<Entry> getUnarchivedEntries();

  @Query(value = "{archived : false, userId: ?1, context: ?2}", count = true)
  int countUnarchived(String userId, String context);

  @Query("{archived : false, user:?1, context: ?2}")
  List<Entry> getEntriesByUserAndContext(String userId, String context);

}
