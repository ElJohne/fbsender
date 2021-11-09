package games.ani.fbsender.repository;

import games.ani.fbsender.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT u FROM User u WHERE u.Username = ?1")
    User findByUsername(String username);

    List<User> findAll();
}
