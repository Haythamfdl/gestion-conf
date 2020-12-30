package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Repos.ConferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class CoferenceController {
    @Autowired
    private ConferenceRepo conferenceRepo;
    @GetMapping("/conferences")
    public List<Conference> getConferences(){
        return conferenceRepo.findAllByTerminerAndDeleted(false,false);
    }

    @PostMapping("/conferences")
    public void addConference(Conference conference){
        conferenceRepo.save(conference);
    }


}
