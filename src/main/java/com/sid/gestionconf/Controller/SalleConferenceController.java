package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Hotel;
import com.sid.gestionconf.Model.SalleConference;
import com.sid.gestionconf.Repos.SalleCRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/sallesconferences/disponible/{id}")
    public List<SalleConference> getSConferencesdis(@PathVariable(name = "id") Long id){
        Hotel hotel = new Hotel();
        hotel.setId(id);
        return salleCRepo.findAllByDisponibleAndHotel(true, hotel);
    }
}
