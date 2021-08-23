package ault.InboxApi.Entities.Lists;

import lombok.Data;

@Data
public class AddListEntryRequest {
  public String listId;

  public String entryContent;
}
