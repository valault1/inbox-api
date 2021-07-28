package ault.InboxApi.DataInitialization;

import ault.InboxApi.repositories.*;
import ault.Entities.Entries.Entry;
import ault.InboxApi.models.*;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DataFillerService {
  private final EntryRepository _entryRepository;

  @Autowired
  public DataFillerService(EntryRepository entryRepository) {
    this._entryRepository = entryRepository;
  }

  @PostConstruct
  @Transactional
  public void fillData() {
    try {
      fillEntries();
    } catch (Exception e) {
      System.out.println(e);
    }

    System.out.println("Filled data!");

  }

  private void fillEntries() throws Exception {
    System.out.println("Filling entries");
    System.out.println("\n\n\n\n\n\n\n\n\n");
    JSONArray obj = (JSONArray) new JSONParser()
        .parse(new FileReader("src\\main\\java\\ault\\InboxApi\\DataInitialization\\data\\entities.json"));
    for (var item : obj) {
      ObjectMapper objectMapper = new ObjectMapper();
      System.out.println("Attempting to write entry");
      Entry e = objectMapper.readValue(item.toString(), Entry.class);
      _entryRepository.save(e);
    }

  }
}
