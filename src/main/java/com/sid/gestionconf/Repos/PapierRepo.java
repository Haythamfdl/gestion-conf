package com.sid.gestionconf.Repos;


import com.sid.gestionconf.Model.Papier;
import com.sid.gestionconf.Model.Track;
import com.sid.gestionconf.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PapierRepo extends JpaRepository<Papier, Long> {
    public List<Papier> findAllByTrackAndDeleted(Track track, boolean d);
    public List<Papier> findAllByAuteurAndDeleted(Utilisateur utilisateur, boolean d);
}
