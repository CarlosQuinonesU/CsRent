package csrent.controller;

import csrent.dto.ReservationDTO;
import csrent.model.Reservation;
import csrent.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    RepositoryService repositoryService;


    @GetMapping
    public ResponseEntity<List<Reservation>> getAll(){
        return ResponseEntity.ok(repositoryService.getAll());
    }


    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationDTO reservationDTO){
       return ResponseEntity.ok(repositoryService.add(reservationDTO));
    }

}
