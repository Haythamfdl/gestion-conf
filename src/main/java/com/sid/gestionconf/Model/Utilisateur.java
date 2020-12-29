package com.sid.gestionconf.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String affiliaton;
    private String fonction;
    private String pays;
    @OneToMany(mappedBy = "client")
    private Set<Reservation> reservations;
    @OneToMany(mappedBy = "inviteur")
    private Set<Invitation> invitationsenv;
    @OneToMany(mappedBy = "inviter")
    private Set<Invitation> invitationsrecu;
}
