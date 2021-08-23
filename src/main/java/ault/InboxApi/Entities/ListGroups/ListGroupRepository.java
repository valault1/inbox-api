package ault.InboxApi.Entities.ListGroups;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ListGroupRepository extends MongoRepository<ListGroup, String> {
  
}
