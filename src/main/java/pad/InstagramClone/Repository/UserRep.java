package pad.InstagramClone.Repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import pad.InstagramClone.Users.User;
@SpringBootApplication
public interface UserRep extends JpaRepository<User,Integer> {
    User findByName(String name);
}
