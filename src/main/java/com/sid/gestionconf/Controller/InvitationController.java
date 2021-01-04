package com.sid.gestionconf.Controller;

import com.sid.gestionconf.Model.Conference;
import com.sid.gestionconf.Model.Invitation;
import com.sid.gestionconf.Model.Utilisateur;
import com.sid.gestionconf.Repos.InvitationRepo;
import com.sid.gestionconf.Repos.UtilisateurRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class InvitationController {
    private InvitationRepo invitationRepo;
    private UtilisateurRepo utilisateurRepo;

    public InvitationController(InvitationRepo invitationRepo, UtilisateurRepo utilisateurRepo) {
        this.invitationRepo = invitationRepo;
        this.utilisateurRepo = utilisateurRepo;
    }

    @GetMapping("/invitations/")
    public List<Invitation> getAll(){
        return invitationRepo.findAll();
    }

    @GetMapping("/invitations/env/{id}")
    public List<Invitation> getInvitationenv(@PathVariable(name = "id") Long id){
        Utilisateur utilisateur= new Utilisateur();
        utilisateur.setId(id);
        return invitationRepo.findAllByInviteur(utilisateur);
    }

    @GetMapping("/invitations/recu/{id}")
    public List<Invitation> getInvitationrec(@PathVariable(name = "id") Long id){
        Utilisateur utilisateur= new Utilisateur();
        utilisateur.setId(id);
        return invitationRepo.findAllByInvitee(utilisateur);
    }

    @RequestMapping(value = "/invitations",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Invitation> addInvitation(@RequestBody Invitation invitation)
    {
        Invitation inv = invitationRepo.save(invitation);
        ResponseEntity<Invitation> res=new ResponseEntity<>(inv, HttpStatus.ACCEPTED);
        return res;
    }

    @RequestMapping(value = "/invitations",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Invitation> updateInvitation(@RequestBody Invitation invitation)
    {
        Invitation inv = invitationRepo.save(invitation);
        ResponseEntity<Invitation> res=new ResponseEntity<>(inv, HttpStatus.ACCEPTED);
        return res;
    }

}
