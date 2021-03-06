package com.sid.gestionconf.Repos;


import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Model.Papier;
import com.sid.gestionconf.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PapierRepo extends JpaRepository<Papier, Long> {
    public List<Papier> findAllByConferenceAndDeleted(Conference conference, boolean d);
    public List<Papier> findAllByConferenceAndDeletedAndConfirmer(Conference conference, boolean d, boolean c);
    public List<Papier> findAllByPremierauteurAndDeleted(Utilisateur utilisateur, boolean d);
}
