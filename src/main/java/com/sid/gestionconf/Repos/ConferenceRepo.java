package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ConferenceRepo extends JpaRepository<Conference, Long> {
    public List<Conference> findAllByTerminerOrderByIdDesc(boolean t);
    public List<Conference> findAllByTerminerAndDeletedOrderByIdDesc(boolean t,boolean d);
    public List<Conference> findAllByOrganisateurAndDeletedOrderByIdDesc(Utilisateur u,boolean d);
}
