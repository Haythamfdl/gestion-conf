package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Session;
import com.sid.gestionconf.Model.Track;
import com.sid.gestionconf.Repos.TrackRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TrackController {
    private TrackRepo trackController;

    public TrackController(TrackRepo trackController) {
        this.trackController = trackController;
    }

    @GetMapping( "/tracks/{id}")
    public List<Track> getTracks(@PathVariable(name = "id") Long id){
        Session session= new Session();
        session.setId(id);
        return trackController.findAllBySessionAndDeleted(session,false);
    }

    @RequestMapping(value = "/tracks",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Track> addTrack(@RequestBody Track track)
    {
        Track tra = trackController.save(track);
        ResponseEntity<Track> res=new ResponseEntity<>(tra, HttpStatus.ACCEPTED);
        return res;
    }

    @RequestMapping(value = "/tracks",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Track> updateTrack(@RequestBody Track track)
    {
        Track tra = trackController.save(track);
        ResponseEntity<Track> res=new ResponseEntity<>(tra, HttpStatus.ACCEPTED);
        return res;
    }
}
