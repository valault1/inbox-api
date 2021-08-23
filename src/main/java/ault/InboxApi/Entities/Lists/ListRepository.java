package ault.InboxApi.Entities.Lists;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ListRepository extends MongoRepository<List, String> {
  @Query("{listGroupId: ?0}")
  java.util.List<List> getListsByGroup(String listGroupId);
}
