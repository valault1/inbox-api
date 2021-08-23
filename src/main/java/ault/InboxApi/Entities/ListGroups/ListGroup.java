package ault.InboxApi.Entities.ListGroups;

import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class ListGroup {

  @Id
  private String id;

  private String name;

  private String userId;
  

  public ListGroup(String name, String userId) {
    this.name = name;
    this.userId = userId;
  }

}