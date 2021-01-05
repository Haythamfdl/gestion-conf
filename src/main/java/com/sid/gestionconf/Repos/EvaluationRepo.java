package com.sid.gestionconf.Repos;

import com.sid.gestionconf.Model.Evaluation;
import com.sid.gestionconf.Model.Papier;
import com.sid.gestionconf.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EvaluationRepo extends JpaRepository<Evaluation, Long> {
    public List<Evaluation> findAllByEvaluateurAndDeleted(Utilisateur utilisateur, boolean b);
    public List<Evaluation> findAllByPapierAndDeleted(Papier papier, boolean b);
}
