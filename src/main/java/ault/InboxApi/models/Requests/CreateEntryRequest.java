package ault.InboxApi.models.Requests;

import java.util.List;

import org.json.simple.JSONObject;

import lombok.Data;

@Data
public class CreateEntryRequest {

  private String entityTypeId;

  private String name;

  private JSONObject entityProperties;

  private List<String> tags;

}
