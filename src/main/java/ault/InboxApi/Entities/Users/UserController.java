package ault.InboxApi.Entities.Users;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
  private final UserService _userService;

  @Autowired
  public UserController(UserService entryService) {
    this._userService = entryService;
  }

  @PutMapping("/user")
  public String createUser(@RequestBody CreateUserRequest request) {
    return _userService.createUser(request);
  }

  @PostMapping("/user/authenticate")
  public boolean entityCount(@RequestBody AuthenticateUserRequest request) {
    return _userService.authenticateUser(request.username, request.password);
  }

  @GetMapping("/user/{username}")
  public User getUser(@PathVariable("username") String username) {
    User user = _userService.getUser(username);
    return user;
  }

}