package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SessionRepo extends JpaRepository<Session, Long> {
}
