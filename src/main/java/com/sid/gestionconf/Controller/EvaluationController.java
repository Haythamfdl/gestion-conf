package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Evaluation;
import com.sid.gestionconf.Model.Papier;
import com.sid.gestionconf.Model.Track;
import com.sid.gestionconf.Model.Utilisateur;
import com.sid.gestionconf.Repos.EvaluationRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EvaluationController {
    private EvaluationRepo evaluationRepo;

    public EvaluationController(EvaluationRepo evaluationRepo) {
        this.evaluationRepo = evaluationRepo;
    }

    @GetMapping( "/evaluations/{id}")
    public List<Evaluation> getEvaluationsP(@PathVariable(name = "id") Long id){
        Papier papier= new Papier();
        papier.setId(id);
        return evaluationRepo.findAllByPapierAndDeleted(papier,false);
    }

    @GetMapping( "/evaluations/my/{id}")
    public List<Evaluation> getEvaluationsU(@PathVariable(name = "id") Long id){
        Utilisateur utilisateur= new Utilisateur();
        utilisateur.setId(id);
        return evaluationRepo.findAllByEvaluateurAndDeleted(utilisateur,false);
    }

    @RequestMapping(value = "/evaluations",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Evaluation> addEvaluation(@RequestBody Evaluation evaluation)
    {
        evaluation.setDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        Evaluation eva = evaluationRepo.save(evaluation);
        ResponseEntity<Evaluation> res=new ResponseEntity<>(eva, HttpStatus.ACCEPTED);
        return res;
    }

    @RequestMapping(value = "/evaluations",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Evaluation> updatePapier(@RequestBody Evaluation evaluation)
    {
        Evaluation eva = evaluationRepo.save(evaluation);
        ResponseEntity<Evaluation> res=new ResponseEntity<>(eva, HttpStatus.ACCEPTED);
        return res;
    }
}
