package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Model.Reservation;
import com.sid.gestionconf.Model.Utilisateur;
import com.sid.gestionconf.Repos.ReservationRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ReservationController {
    private ReservationRepo reservationRepo;

    public ReservationController(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    @GetMapping("/reservations/{id}")
    public List<Reservation> getReservation(@PathVariable(name = "id") Long id){
        Utilisateur utilisateur=new Utilisateur();
        utilisateur.setId(id);
        return reservationRepo.findAllByClientAndDeleted(utilisateur,false);
    }

    @RequestMapping(value = "/reservations",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation)
    {
        Reservation resr = reservationRepo.save(reservation);
        ResponseEntity<Reservation> res=new ResponseEntity<>(resr, HttpStatus.ACCEPTED);
        return res;
    }

    @RequestMapping(value = "/reservations",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation)
    {
        Reservation resr = reservationRepo.save(reservation);
        ResponseEntity<Reservation> res=new ResponseEntity<>(resr, HttpStatus.ACCEPTED);
        return res;
    }
}
