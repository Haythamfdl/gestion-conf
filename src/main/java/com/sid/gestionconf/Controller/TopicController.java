package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Model.Papier;
import com.sid.gestionconf.Model.Topic;
import com.sid.gestionconf.Repos.TopicRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {
    private TopicRepo topicRepo;

    public TopicController(TopicRepo topicRepo) {
        this.topicRepo = topicRepo;
    }

    @GetMapping("/topics/{id}")
    public List<Topic> getAll(@PathVariable(name = "id")Long id){
        Conference conference= new Conference();
        conference.setId(id);
        return topicRepo.findAllByConferenceAndDeleted(conference,false);
    }

    @RequestMapping(value = "/topics",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic)
    {
        Topic top = topicRepo.save(topic);
        ResponseEntity<Topic> res=new ResponseEntity<>(top, HttpStatus.ACCEPTED);
        return res;
    }

    @RequestMapping(value = "/topics",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic)
    {
        Topic top = topicRepo.save(topic);
        ResponseEntity<Topic> res=new ResponseEntity<>(top, HttpStatus.ACCEPTED);
        return res;
    }
}
