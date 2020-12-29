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
public class Papier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne()
	@JoinColumn(name = "idpauteur", referencedColumnName = "id")
	private Utilisateur premierauteur;
	@OneToOne()
	@JoinColumn(name = "idauteur", referencedColumnName = "id")
	private Utilisateur auteur;
	@OneToOne()
	@JoinColumn(name = "idpresentateur", referencedColumnName = "id")
	private Utilisateur presentateur;
	@OneToMany(mappedBy = "papier")
	private Set<Evaluation> evaluations;
	private String nom;
	private String description;
	private Boolean confirmer;
	@OneToOne()
	@JoinColumn(name = "idtopic", referencedColumnName = "id")
	private Topic topic;
	@Lob
	@Column(columnDefinition = "BLOB")
	private byte[] data;

}