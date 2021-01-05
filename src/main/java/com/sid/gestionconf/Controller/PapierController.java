package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Papier;
import com.sid.gestionconf.Model.Session;
import com.sid.gestionconf.Model.Track;
import com.sid.gestionconf.Model.Utilisateur;
import com.sid.gestionconf.Repos.PapierRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Track track= new Track();
        track.setId(id);
        return papierRepo.findAllByTrackAndDeleted(track,false);
    }

    @GetMapping( "/papiers/my/{id}")
    public List<Papier> getmyPapiers(@PathVariable(name = "id") Long id){
        Utilisateur utilisateur= new Utilisateur();
        utilisateur.setId(id);
        return papierRepo.findAllByAuteurAndDeleted(utilisateur,false);
    }

    @RequestMapping(value = "/papiers",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Papier> addPapier(@RequestBody Papier papier)
    {
        Papier pap = papierRepo.save(papier);
        ResponseEntity<Papier> res=new ResponseEntity<>(pap, HttpStatus.ACCEPTED);
        return res;
    }

    @RequestMapping(value = "/papiers",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Papier> updatePapier(@RequestBody Papier papier)
    {
        Papier pap = papierRepo.save(papier);
        ResponseEntity<Papier> res=new ResponseEntity<>(pap, HttpStatus.ACCEPTED);
        return res;
    }
}
