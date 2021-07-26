package ault.InboxApi.repositories;

import ault.InboxApi.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntryRepository extends MongoRepository<Entry, String> {

}
