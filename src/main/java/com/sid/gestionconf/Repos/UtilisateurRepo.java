package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
    public Utilisateur findByEmailAndPassAndDeleted(String e, String p,Boolean d);
}
