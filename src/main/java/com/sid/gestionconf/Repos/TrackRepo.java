package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Session;
import com.sid.gestionconf.Model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TrackRepo extends JpaRepository<Track, Long> {
    public List<Track> findAllBySessionAndDeleted(Session session,boolean d);
}
