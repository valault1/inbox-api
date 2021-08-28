package ault.InboxApi.Entities.Entries;


import lombok.Data;

@Data
public class CreateEntryRequest {

  public String content;

  public String userId;

  public String context;

}
