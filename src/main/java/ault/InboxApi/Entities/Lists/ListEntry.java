package ault.InboxApi.Entities.Lists;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class ListEntry{

  @Id
  private String id;

  private String content;

  private boolean completed;
  

  public ListEntry(String content) {
    this.content = content;
  }

}