package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TopicRepo extends JpaRepository<Topic, Long> {
}
