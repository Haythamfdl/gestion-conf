package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Repos.ConferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class CoferenceController {
    @Autowired
    private ConferenceRepo conferenceRepo;
    @GetMapping("/conferences")
    public List<Conference> getConferences(){
        return conferenceRepo.findAllByTerminer(false);
    }
}
