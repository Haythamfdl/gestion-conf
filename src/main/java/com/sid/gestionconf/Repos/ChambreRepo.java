package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ChambreRepo extends JpaRepository<Chambre, Long> {
}
