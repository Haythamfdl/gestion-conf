package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Model.Topic;
import com.sid.gestionconf.Repos.TopicRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {
    private TopicRepo topicRepo;

    public TopicController(TopicRepo topicRepo) {
        this.topicRepo = topicRepo;
    }

    @GetMapping("/topics")
    public List<Topic> getAll(){
        return topicRepo.findAll();
    }
}
