package ault.InboxApi.DataInitialization;

import ault.InboxApi.Entities.Entries.Entry;
import ault.InboxApi.Entities.Entries.EntryRepository;
import ault.InboxApi.Entities.Users.User;
import ault.InboxApi.Entities.Users.UserRepository;
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
  private final UserRepository _userRepository;

  @Autowired
  public DataFillerService(EntryRepository entryRepository, UserRepository userRepository) {
    this._entryRepository = entryRepository;
    this._userRepository = userRepository;
  }

  @PostConstruct
  @Transactional
  public void fillData() {
    try {
      // fillEntries();
      fillUsers();
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

  private void fillUsers() throws Exception {
    System.out.println("Filling users");
    System.out.println("\n\n\n\n\n\n\n\n\n");
    JSONArray obj = (JSONArray) new JSONParser()
        .parse(new FileReader("src\\main\\java\\ault\\InboxApi\\DataInitialization\\data\\users.json"));
    for (var item : obj) {
      ObjectMapper objectMapper = new ObjectMapper();
      System.out.println("Attempting to write entry");
      User e = objectMapper.readValue(item.toString(), User.class);
      _userRepository.save(e);
    }
  }
}
