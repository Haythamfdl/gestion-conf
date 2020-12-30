package com.sid.gestionconf;

import com.sid.gestionconf.Repos.ConferenceRepo;
import com.sid.gestionconf.Repos.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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

    }
}
