package games.ani.fbsender.controller;


import games.ani.fbsender.model.User;
import games.ani.fbsender.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list-users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.readById(id), HttpStatus.OK);
    }

    @PostMapping("/new-user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @PutMapping("/update-user")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
