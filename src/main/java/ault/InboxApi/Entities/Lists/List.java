package ault.InboxApi.Entities.Lists;

import java.util.ArrayList;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class List{

  @Id
  private String id;

  private String name;

  private String userId;

  private String listGroupId;

  private java.util.List<ListEntry> entries = new ArrayList<ListEntry>();
  

  public List(String name, String userId, String listGroupId) {
    this.name = name;
    this.userId = userId;
    this.listGroupId = listGroupId;
  }


}