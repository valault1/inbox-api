package ault.InboxApi.Entities.Lists;

import lombok.Data;

@Data
public class CreateListRequest {
  public String name;

  public String userId;
}
