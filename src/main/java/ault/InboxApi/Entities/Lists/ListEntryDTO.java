package ault.InboxApi.Entities.Lists;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class ListEntryDTO{

  private String content;

  private boolean completed;
  

  public ListEntryDTO(String content) {
    this.content = content;
  }

  public ListEntryDTO(ListEntry entry) {
    this.content = entry.getContent();
    this.completed = entry.isCompleted();

  }

}