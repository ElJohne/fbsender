package games.ani.fbsender.service.impl;

import games.ani.fbsender.exeption.ApiRequestException;
import games.ani.fbsender.model.User;
import games.ani.fbsender.repository.UserRepository;
import games.ani.fbsender.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        if(user != null) return userRepository.save(user);
        throw new ApiRequestException("Can`t create empty user!");
    }

    @Override
    public User readById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ApiRequestException(String.format("Can`t find user with id=%d!", id)));
    }

    @Override
    public User readByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user != null) return userRepository.findByUsername(username);
        throw new ApiRequestException(String.format("Can`t find user with username=\"%s\"!", username));
    }

    @Override
    public User update(User user) {
        if (user != null) {
            readById(user.getId());
            return userRepository.save(user);
        }
        throw new ApiRequestException("Can`t update user!");
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
