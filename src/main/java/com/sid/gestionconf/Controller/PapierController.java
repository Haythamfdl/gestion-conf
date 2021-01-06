package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.*;
import com.sid.gestionconf.Repos.PapierRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PapierController {
    private PapierRepo papierRepo;

    public PapierController(PapierRepo papierRepo) {
        this.papierRepo = papierRepo;
    }

    @GetMapping( "/papiers/{id}")
    public List<Papier> getPapiers(@PathVariable(name = "id") Long id){
        Conference conference= new Conference();
        conference.setId(id);
        return papierRepo.findAllByConferenceAndDeleted(conference,false);
    }

    @GetMapping( "/papiers/confirmer/{id}")
    public List<Papier> getCPapiers(@PathVariable(name = "id") Long id){
        Conference conference= new Conference();
        conference.setId(id);
        return papierRepo.findAllByConferenceAndDeletedAndConfirmer(conference,false,true);
    }

    @GetMapping( "/papiers/my/{id}")
    public List<Papier> getmyPapiers(@PathVariable(name = "id") Long id){
        Utilisateur utilisateur= new Utilisateur();
        utilisateur.setId(id);
        return papierRepo.findAllByPremierauteurAndDeleted(utilisateur,false);
    }

    @RequestMapping(value = "/papiers",method = RequestMethod.POST)
    public ResponseEntity<Papier> addPapier(@RequestBody Papier papier)
    {
        Papier pap = papierRepo.save(papier);
        ResponseEntity<Papier> res=new ResponseEntity<>(pap, HttpStatus.ACCEPTED);
        return res;
    }

    @RequestMapping(value = "/papiers/file",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void upload(@RequestBody MultipartFile file)
    {

    }

    @RequestMapping(value = "/papiers",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Papier> updatePapier(@RequestBody Papier papier)
    {
        Papier pap = papierRepo.save(papier);
        ResponseEntity<Papier> res=new ResponseEntity<>(pap, HttpStatus.ACCEPTED);
        return res;
    }
}
