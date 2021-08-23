package ault.InboxApi.Entities.Entries;

import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Entry {

  @Id
  private String id;

  private String content;

  private Date creationDate;

  private String userId;

  private boolean archived;

  private String context;
  

  public Entry(String content) {
    this.content = content;
    this.creationDate = new Date();
  }

  public Entry(String content, String userId, String context) {
    this.content = content;
    this.userId = userId;
    this.creationDate = new Date();
    this.context = context;
  }

}