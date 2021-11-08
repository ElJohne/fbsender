package games.ani.fbsender.service.impl;

import games.ani.fbsender.model.User;
import games.ani.fbsender.repository.UserRepository;
import games.ani.fbsender.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(){
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User readById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User readByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User update(User user) {
        User oldUser = readById(user.getId());
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(userRepository.getById(id));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
