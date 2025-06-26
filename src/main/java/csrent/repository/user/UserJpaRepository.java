package csrent.repository.user;

import csrent.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);
    User getByEmail(String email);
}
