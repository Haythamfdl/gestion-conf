package com.sid.gestionconf.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Reservation> reservations;
    @OneToMany(mappedBy = "inviteur")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Invitation> invitationsenv;
    @OneToMany(mappedBy = "inviter")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Invitation> invitationsrecu;
    @Column(columnDefinition = "boolean default false")
    private Boolean deleted;
}
