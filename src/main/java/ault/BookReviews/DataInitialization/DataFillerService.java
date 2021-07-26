package ault.BookReviews.DataInitialization;

import ault.BookReviews.repositories.*;
import ault.BookReviews.models.*;
import ault.BookReviews.models.BookReview.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DataFillerService {
  private final EntityRepository _entityRepository;

  @Autowired
  public DataFillerService(EntityRepository entityRepository) {
    this._entityRepository = entityRepository;
  }

  @PostConstruct
  @Transactional
  public void fillData() {
    try {
      fillEntities();
    } catch (Exception e) {
      System.out.println(e);
    }

    System.out.println("Filled data!");

  }

  private void fillEntities() throws Exception {
    JSONArray obj = (JSONArray) new JSONParser()
        .parse(new FileReader("src\\main\\java\\ault\\BookReviews\\DataInitialization\\data\\entities.json"));
    for (var item : obj) {
      ObjectMapper objectMapper = new ObjectMapper();
      System.out.println("Attempting to write entity");
      Entity e = objectMapper.readValue(item.toString(), Entity.class);
      _entityRepository.save(e);
    }

  }
}
