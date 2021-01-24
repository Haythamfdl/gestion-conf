package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Hotel;
import com.sid.gestionconf.Model.SalleConference;
import com.sid.gestionconf.Repos.SalleCRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SalleConferenceController {
    private SalleCRepo salleCRepo;

    public SalleConferenceController(SalleCRepo salleCRepo) {
        this.salleCRepo = salleCRepo;
    }

    @GetMapping("/sallesconferences")
    public List<SalleConference> getSConferences(){
        return salleCRepo.findAll();
    }

    @GetMapping("/sallesconferences/{id}")
    public List<SalleConference> getAllSConferenceshot(@PathVariable(name = "id") Long id){
        Hotel hotel = new Hotel();
        hotel.setId(id);
        return salleCRepo.findAllByDisponibleAndHotel(true, hotel);
    }

    @GetMapping("/sallesconferences/disponible/{id}")
    public List<SalleConference> getSConferencesdis(@PathVariable(name = "id") Long id){
        Hotel hotel = new Hotel();
        hotel.setId(id);
        return salleCRepo.findAllByDisponibleAndHotel(true, hotel);
    }

    @RequestMapping(value = "/sallesconferences",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalleConference> addSalleC(@RequestBody SalleConference salleConference)
    {
        SalleConference sc = salleCRepo.save(salleConference);
        ResponseEntity<SalleConference> res=new ResponseEntity<>(sc, HttpStatus.ACCEPTED);
        return res;
    }

    @RequestMapping(value = "/sallesconferences",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalleConference> updateSalleC(@RequestBody SalleConference salleConference)
    {
        SalleConference sc = salleCRepo.save(salleConference);
        ResponseEntity<SalleConference> res=new ResponseEntity<>(sc, HttpStatus.ACCEPTED);
        return res;
    }
}
