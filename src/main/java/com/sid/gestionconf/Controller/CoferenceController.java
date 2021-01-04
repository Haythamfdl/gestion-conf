package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Model.Utilisateur;
import com.sid.gestionconf.Repos.ConferenceRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class CoferenceController {
    private ConferenceRepo conferenceRepo;

    public CoferenceController(ConferenceRepo conferenceRepo) {
        this.conferenceRepo = conferenceRepo;
    }

    @GetMapping("/conferences")
    public List<Conference> getConferences(){
        return conferenceRepo.findAllByTerminerAndDeletedOrderByIdDesc(false,false);
    }

    @GetMapping ( "/conferences/myconf/{id}")
    public List<Conference> getMyConferences(@PathVariable(name = "id") Long id){
        Utilisateur utilisateur= new Utilisateur();
        utilisateur.setId(id);
        return conferenceRepo.findAllByOrganisateurAndDeletedOrderByIdDesc(utilisateur,false);
    }

    @RequestMapping(value = "/conferences",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Conference> addConference(@RequestBody Conference conference)
    {
        Conference conf = conferenceRepo.save(conference);
        ResponseEntity<Conference> res=new ResponseEntity<>(conf, HttpStatus.ACCEPTED);
        return res;
    }

    @RequestMapping(value = "/conferences",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Conference> modifyConference(@RequestBody Conference conference)
    {
        Conference conf = conferenceRepo.save(conference);
        ResponseEntity<Conference> res=new ResponseEntity<>(conf, HttpStatus.ACCEPTED);
        return res;
    }

}
