package csrent.service;

import csrent.dto.ReservationDTO;
import csrent.model.Reservation;
import csrent.model.space.Space;
import csrent.model.user.User;
import csrent.repository.JPAReservacionRepository;
import csrent.service.space.SpaceService;
import csrent.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepositoryService {

//    @Autowired
    private JPAReservacionRepository reservacionRepository;
    private UserService userService;
    private SpaceService spaceService;

    public RepositoryService(JPAReservacionRepository reservacionRepository, UserService userService, SpaceService spaceService) {
        this.reservacionRepository = reservacionRepository;
        this.userService = userService;
        this.spaceService = spaceService;
    }

    public List<Reservation> getAll(){
        return reservacionRepository.findAll();
    }

    public Reservation add(ReservationDTO reservationDTO){
        User user= userService.getByEmail(reservationDTO.getEmailUser());
        Space space= spaceService.search(reservationDTO.getIdSpace());
        Reservation reservation=  new Reservation();
        reservation.setUser(user);
        reservation.setSpace(space);
        reservation.setDateReservacion(reservationDTO.getDate());
        reservation.setStatus(reservationDTO.getStatus());
        return reservacionRepository.save(reservation);
    }


}
