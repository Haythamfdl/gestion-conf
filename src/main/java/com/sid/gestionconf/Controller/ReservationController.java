package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Reservation;
import com.sid.gestionconf.Repos.ReservationRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ReservationController {
    private ReservationRepo reservationRepo;

    public ReservationController(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations(){
        return reservationRepo.findAll();
    }

    @GetMapping("/reservations/{id}")
    public Reservation getReservation(@PathVariable(name = "id") Long id){
        return reservationRepo.findById(id).get();
    }
}
