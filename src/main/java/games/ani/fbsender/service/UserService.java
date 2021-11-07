package games.ani.fbsender.service;

import games.ani.fbsender.model.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User readById(Long id);
    User readByUsername(String username);
    User update(User user);
    void delete(Long id);
    List<User> getAll();
}
