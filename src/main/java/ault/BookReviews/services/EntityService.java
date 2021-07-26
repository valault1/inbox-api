package ault.BookReviews.services;

import ault.BookReviews.repositories.*;
import ault.BookReviews.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class EntityService {
  private final EntityRepository _entityRepository;

  @Autowired
  public EntityService(EntityRepository entityRepository) {
    this._entityRepository = entityRepository;
  }

  public Optional<Entity> entity(String id) {
    return _entityRepository.findById(id);
  }

  public List<Entity> entities() {
    return _entityRepository.findAll();
  }

  public long entityCount() {
    return _entityRepository.count();
  }

  public String updateEntity(Entity updatedEntity) {
    System.out.println(updatedEntity);
    _entityRepository.save(updatedEntity);
    return updatedEntity.getId();
  }

  public List<String> getTags() {
    var entities = entities();
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
