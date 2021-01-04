package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Model.Session;
import com.sid.gestionconf.Repos.SessionRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SessionController {
    private SessionRepo sessionRepo;

    public SessionController(SessionRepo sessionRepo) {
        this.sessionRepo = sessionRepo;
    }

    @GetMapping("/sessions/{id}")
    public List<Session> getSessions(@PathVariable(name = "id") long id){
        Conference conference =new Conference();
        conference.setId(id);
        return sessionRepo.findAllByConferenceAndDeleted(conference,false);
    }

    @RequestMapping(value = "/sessions",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Session> addSession(@RequestBody Session session)
    {
        Session ses = sessionRepo.save(session);
        ResponseEntity<Session> res=new ResponseEntity<>(ses, HttpStatus.ACCEPTED);
        return res;
    }

    @RequestMapping(value = "/sessions",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Session> updateSession(@RequestBody Session session)
    {
        Session ses = sessionRepo.save(session);
        ResponseEntity<Session> res=new ResponseEntity<>(ses, HttpStatus.ACCEPTED);
        return res;
    }
}
