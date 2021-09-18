package ault.InboxApi.Entities.Entries;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EntryRepository extends MongoRepository<Entry, String> {
  @Query("{archived : false}")
  List<Entry> getUnarchivedEntries();

  @Query(value = "{archived : false, userId: ?0, context: ?1}", count = true)
  int countUnarchived(String userId, String context);

  @Query(value = "{archived : false, userId: ?0}", count = true)
  int countUnarchived(String userId);

  @Query("{archived : false, userId:?0, context: ?1}")
  List<Entry> getCurrentEntries(String userId, String context);

}
