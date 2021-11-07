package games.ani.fbsender.repository;

import games.ani.fbsender.model.Answer;
import games.ani.fbsender.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    Answer getByAuthor(User author);
    void deleteAllByAuthor(User author);
    List<Answer> findAllByAuthor(User author);
}
