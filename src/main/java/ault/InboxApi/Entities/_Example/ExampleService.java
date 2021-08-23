package ault.InboxApi.Entities._Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExampleService {
  private final ExampleRepository _exampleRepository;

  @Autowired
  public ExampleService(ExampleRepository exampleRepository) {
    this._exampleRepository = exampleRepository;
  }


}
