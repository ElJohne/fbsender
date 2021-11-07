package games.ani.fbsender.service.impl;

import games.ani.fbsender.model.Answer;
import games.ani.fbsender.model.User;
import games.ani.fbsender.repository.AnswerRepository;
import games.ani.fbsender.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerRepository answerRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer create(Answer answer) {
        return null;
    }

    @Override
    public Answer readById(Long id) {
        return null;
    }

    @Override
    public Answer readByUser(Answer answer) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteByUser(User user) {

    }

    @Override
    public List<Answer> getAll() {
        return null;
    }

    @Override
    public List<Answer> getAllByUser(User user) {
        return null;
    }
}
