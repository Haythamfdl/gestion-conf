package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TacksRepo extends JpaRepository<Track, Long> {
}
