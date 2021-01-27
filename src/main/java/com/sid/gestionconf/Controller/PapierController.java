package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Model.Papier;
import com.sid.gestionconf.Model.Utilisateur;
import com.sid.gestionconf.Repos.PapierRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @RequestMapping(value = "/papiers",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Papier addPapier(@RequestBody Papier papier)
    {
        Papier pap = papierRepo.save(papier);
        return pap;
    }

    public Papier store(Long id,MultipartFile file) throws IOException {
        Papier papier = new Papier();
        papier.setId(id);
        papier.setData(file.getBytes());
        return papierRepo.save(papier);
    }

    @RequestMapping(value = "/papiers/upload/{id}",method = RequestMethod.POST)
    public void upload(@RequestParam("file") MultipartFile file, @PathVariable(name = "id") Long id) throws IOException {
        this.store(id,file);
    }

    @RequestMapping(value = "/papiers",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Papier> updatePapier(@RequestBody Papier papier)
    {
        Papier p = papierRepo.save(papier);
        ResponseEntity<Papier> res=new ResponseEntity<>(p, HttpStatus.ACCEPTED);
        return res;
    }


}
