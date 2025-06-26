package csrent.repository.space;

import csrent.model.space.Space;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceJpaRepository extends JpaRepository<Space, Integer> {
    boolean existsByName(String name);

}
