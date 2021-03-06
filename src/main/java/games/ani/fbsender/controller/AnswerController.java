package games.ani.fbsender.controller;


import games.ani.fbsender.model.Answer;
import games.ani.fbsender.model.User;
import games.ani.fbsender.service.AnswerService;
import games.ani.fbsender.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private final AnswerService answerService;
    private final UserService userService;

    public AnswerController(AnswerService answerService, UserService userService) {
        this.answerService = answerService;
        this.userService = userService;
    }

    @GetMapping("/list-answers")
    public ResponseEntity<List<Answer>> getAllAnswers(){
        return new ResponseEntity<>(answerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable("id") Long id){
        return new ResponseEntity<>(answerService.readById(id), HttpStatus.OK);
    }

    @GetMapping("/find/{user_id}")
    public ResponseEntity<Answer> getAnswerByUser(@PathVariable("user_id") Long user_id){
        return new ResponseEntity<>(answerService.readByUser(userService.readById(user_id)), HttpStatus.OK);
    }

    @PostMapping("/new-answer")
    public ResponseEntity<Answer> addAnswer(@RequestBody Answer answer){
        return new ResponseEntity<>(answerService.create(answer), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-answer/{id}")
    public ResponseEntity<?> deleteAnswer(@PathVariable("id") Long id){
        answerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
