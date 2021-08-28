package ault.InboxApi.Entities.Lists;

import lombok.Data;

@Data
public class UpdateListEntryRequest {
  public int index;

  public String listId;

  public ListEntryDTO entry;

}
