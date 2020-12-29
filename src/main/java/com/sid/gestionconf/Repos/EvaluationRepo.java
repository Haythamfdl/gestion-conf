package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EvaluationRepo extends JpaRepository<Evaluation, Long> {
}
