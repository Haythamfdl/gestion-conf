package com.sid.gestionconf;

import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Model.Utilisateur;
import com.sid.gestionconf.Repos.ConferenceRepo;
import com.sid.gestionconf.Repos.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionConfApplication implements CommandLineRunner {
    @Autowired
    private UtilisateurRepo utilisateurRepo;
    @Autowired
    private ConferenceRepo conferenceRepo;

    public static void main(String[] args) {
        SpringApplication.run(GestionConfApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Utilisateur u= new Utilisateur(null,"n","p","","","","maroc");
        utilisateurRepo.save(u);
        conferenceRepo.save(new Conference(null,u,"",null,"","","","",5,null,5,0,false));
    }
}
