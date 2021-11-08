package games.ani.fbsender.service.impl;

import games.ani.fbsender.model.Answer;
import games.ani.fbsender.model.User;
import games.ani.fbsender.repository.AnswerRepository;
import games.ani.fbsender.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerServiceImpl(){}

    @Override
    public Answer create(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer readById(Long id) {
        return answerRepository.getById(id);
    }

    @Override
    public Answer readByUser(User user) {
        return answerRepository.getByAuthor(user);
    }

    @Override
    public void delete(Long id) {
        answerRepository.delete(answerRepository.getById(id));
    }

    @Override
    public void deleteByUser(User user) {
        answerRepository.deleteAllByAuthor(user);
    }

    @Override
    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    @Override
    public List<Answer> getAllByUser(User user) {
        return answerRepository.findAllByAuthor(user);
    }
}
