package csrent.repository;

import csrent.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAReservacionRepository extends JpaRepository<Reservation, Integer> {
}
