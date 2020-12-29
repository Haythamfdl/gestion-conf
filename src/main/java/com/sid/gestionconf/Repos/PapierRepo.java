package com.sid.gestionconf.Repos;


import com.sid.gestionconf.Model.Papier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PapierRepo extends JpaRepository<Papier, Long> {
}
