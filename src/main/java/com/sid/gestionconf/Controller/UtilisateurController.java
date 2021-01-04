package com.sid.gestionconf.Controller;


import com.sid.gestionconf.Model.Utilisateur;
import com.sid.gestionconf.Repos.UtilisateurRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UtilisateurController {
    private UtilisateurRepo utilisateurRepo;

    public UtilisateurController(UtilisateurRepo utilisateurRepo) {
        this.utilisateurRepo = utilisateurRepo;
    }

    @GetMapping("/utilisateurs")
    public List<Utilisateur> getUtilisateurs(){
        return utilisateurRepo.findAll();
    }

    @GetMapping("/utilisateurs/{email}/{pass}")
    public Utilisateur Login(@PathVariable String email,@PathVariable String pass ){
        return utilisateurRepo.findByEmailAndPassAndDeleted(email, pass, false);
    }

    @GetMapping("/utilisateurs/{email}")
    public Utilisateur getbyEmail(@PathVariable String email){
        return utilisateurRepo.findByEmailAndDeleted(email, false);
    }

    @RequestMapping(value = "/utilisateurs",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur)
    {
        Utilisateur user = utilisateurRepo.save(utilisateur);
        ResponseEntity<Utilisateur> res=new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        return res;
    }

    @RequestMapping(value = "/utilisateurs",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody Utilisateur utilisateur)
    {
        Utilisateur user = utilisateurRepo.save(utilisateur);
        ResponseEntity<Utilisateur> res=new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        return res;
    }
}
