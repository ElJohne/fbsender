package games.ani.fbsender.service;

import games.ani.fbsender.model.Answer;
import games.ani.fbsender.model.User;

import java.util.List;

public interface AnswerService {
    Answer create(Answer answer);
    Answer readById(Long id);
    Answer readByUser(User user);
    void delete(Long id);
    void deleteByUser(User user);
    List<Answer> getAll();
    List<Answer> getAllByUser(User user);
}
