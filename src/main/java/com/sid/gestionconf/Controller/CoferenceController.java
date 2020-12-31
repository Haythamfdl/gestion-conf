package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Model.Hotel;
import com.sid.gestionconf.Repos.ConferenceRepo;
import com.sid.gestionconf.Repos.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class CoferenceController {
    @Autowired
    private ConferenceRepo conferenceRepo;
    @Autowired
    private HotelRepo hotelRepo;
    @GetMapping("/conferences")
    public List<Conference> getConferences(){
        return conferenceRepo.findAllByTerminerAndDeleted(false,false);
    }

    @RequestMapping(value = "/conferences",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Conference> addConference(@RequestBody Conference conference)
    {
        conferenceRepo.save(conference);
        ResponseEntity<Conference> res=new ResponseEntity<>(conference, HttpStatus.ACCEPTED);
        return res;
    }


}
