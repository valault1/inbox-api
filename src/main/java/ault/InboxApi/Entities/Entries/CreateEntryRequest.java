package ault.InboxApi.Entities.Entries;

import java.util.List;

import org.json.simple.JSONObject;

import lombok.Data;

@Data
public class CreateEntryRequest {

  public String content;

  public String userId;

  public String context;

}
