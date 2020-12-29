package com.sid.gestionconf.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InvitationRepo extends JpaRepository<com.sid.gestionconf.Model.Invitation, Long> {
}
