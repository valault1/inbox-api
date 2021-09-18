package ault.InboxApi.Entities.Lists;

import lombok.Data;

@Data
public class UpdateListNameRequest {
  public String listId;

  public String name;
}
