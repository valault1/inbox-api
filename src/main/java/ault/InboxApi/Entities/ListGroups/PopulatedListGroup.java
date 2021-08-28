package ault.InboxApi.Entities.ListGroups;

import java.util.ArrayList;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ault.InboxApi.Entities.Lists.List;

@Data
@Document
@NoArgsConstructor
public class PopulatedListGroup {

  @Id
  private String id;

  private String name;

  private String userId;

  private java.util.List<List> lists;
  

  public PopulatedListGroup(String id, String name, String userId) {
    this.id = id;
    this.name = name;
    this.userId = userId;
    lists = new ArrayList<List>();
  }

}