package ault.InboxApi.Entities.Users;

import lombok.Data;

@Data
public class AuthenticateUserRequest {
  String username;
  String password;
}
