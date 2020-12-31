package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Model.Hotel;
import com.sid.gestionconf.Model.SalleConference;
import com.sid.gestionconf.Repos.SalleCRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SalleConferenceController {
    @Autowired
    SalleCRepo salleCRepo;

    @GetMapping("/sallesconferences")
    public List<SalleConference> getSConferences(){
        return salleCRepo.findAll();
    }

    @GetMapping("/sallesconferences/disponible/{hotel}")
    public List<SalleConference> getSConferencesdis(@PathVariable(name = "hotel") Hotel hotel){
        return salleCRepo.findAllByDisponibleAndHotel(true, hotel);
    }
}
