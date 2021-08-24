package ault.InboxApi.Entities.ListGroups;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ListGroupRepository extends MongoRepository<ListGroup, String> {
  @Query("{userId: ?0}")
  java.util.List<ListGroup> getListGroupsByUser(String userId);
}
