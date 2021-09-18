package ault.InboxApi.Entities.Lists;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class ListEntry{

  private String content;

  private boolean completed;

  private int index;
  

  public ListEntry(String content) {
    this.content = content;
  }

  public ListEntry(ListEntryDTO dto) {
    this.content = dto.getContent();
    this.completed = dto.isCompleted();
    this.index = dto.getIndex();
  }

}