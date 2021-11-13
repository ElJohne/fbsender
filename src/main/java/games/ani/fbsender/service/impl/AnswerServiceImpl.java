package games.ani.fbsender.service.impl;

import games.ani.fbsender.exeption.ApiRequestException;
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

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer create(Answer answer) {
        if(answer != null) return answerRepository.save(answer);
        throw new ApiRequestException("Can`t create empty answer!");
    }

    @Override
    public Answer readById(Long id) {
        return answerRepository.findById(id).orElseThrow(() -> new ApiRequestException(String.format("Can`t find answer with id=%d!",id)));
    }

    @Override
    public Answer readByUser(User user) {
        if(user != null){
            Answer answer = answerRepository.getByAuthor(user);
            if(answer != null){
                return answerRepository.getByAuthor(user);
            }
            throw new ApiRequestException(String.format("Cant find answer with author_id=%d!",user.getId()));
        }
        throw new ApiRequestException("User is not exist!");
    }

    @Override
    public void delete(Long id) {
        answerRepository.delete(answerRepository.getById(id));
    }

    @Override
    public void deleteByUser(User user) {
        if(user != null){
            answerRepository.deleteAllByAuthor(user);
        }
        throw new ApiRequestException("User is not exist!");
    }

    @Override
    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    @Override
    public List<Answer> getAllByUser(User user) {
        if(user != null){
            return answerRepository.findAllByAuthor(user);
        }
        throw new ApiRequestException("User is not exist!");
    }
}
