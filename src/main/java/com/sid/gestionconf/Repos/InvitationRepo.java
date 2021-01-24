package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Model.Invitation;
import com.sid.gestionconf.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface InvitationRepo extends JpaRepository<com.sid.gestionconf.Model.Invitation, Long> {
    public List<Invitation> findAllByInviteOrderByDateDesc(Utilisateur utilisateur);
    public List<Invitation> findAllByInviteurOrderByDateDesc(Utilisateur utilisateur);
    public List<Invitation> findAllByConferenceOrderByDateDesc(Conference conference);
}
