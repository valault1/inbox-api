package ault.InboxApi.Entities.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
  private final UserRepository _userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this._userRepository = userRepository;
  }

  public boolean authenticateUser(String username, String password) {
    User user = _userRepository.findUserByUsername(username);
    System.out.println(user);
    if (user == null || !user.getPassword().equals(password)) {
      System.out.println("RETURNING FALSE");
      return false;
    }
    return true;
  }

  // Creates a user, returns the id.
  // Does not create another user if that username already exists.
  // Still returns that user's id.
  public String createUser(CreateUserRequest request) {
    User user = new User(request.username, request.password);
    List<User> users = _userRepository.findAll();

    boolean alreadyExists = false;
    for (User u : users) {
      if (u.getUsername() == request.username) {
        alreadyExists = true;
        user = u;
      }
    }

    if (!alreadyExists)
      _userRepository.save(user);

    return user.getId();
  }

  public User getUser(String username) {
    return _userRepository.findUserByUsername(username);
  }

}
