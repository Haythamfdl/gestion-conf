package com.sid.gestionconf.Controller;


import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Model.Utilisateur;
import com.sid.gestionconf.Repos.ConferenceRepo;
import com.sid.gestionconf.Repos.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UtilisateurController {
    @Autowired
    private UtilisateurRepo utilisateurRepo;

    @GetMapping("/utilisateurs")
    public List<Utilisateur> getUtilisateurs(){
        return utilisateurRepo.findAll();
    }

    @GetMapping("/utilisateurs/{email}/{pass}")
    public Utilisateur Login(@PathVariable String email,@PathVariable String pass ){
        return utilisateurRepo.findByEmailAndPassAndDeleted(email, pass, false);
    }


}
