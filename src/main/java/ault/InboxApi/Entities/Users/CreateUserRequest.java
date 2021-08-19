package ault.InboxApi.Entities.Users;

import lombok.Data;

@Data
public class CreateUserRequest {

  public String username;
  public String password;

}
