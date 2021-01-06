package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TopicRepo extends JpaRepository<Topic, Long> {
    public List<Topic> findAllByConferenceAndDeleted(Conference conference,boolean d);
}
