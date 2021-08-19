package ault.InboxApi.Entities.Users;

import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class User {

  @Id
  private String id;

  private String username;

  private String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String toString() {
    return ("USER - username: " + username + ", password: " + password);
  }

}