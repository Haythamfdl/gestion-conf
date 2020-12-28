package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.SalleConference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SalleCRepo extends JpaRepository<SalleConference, Long> {
}
