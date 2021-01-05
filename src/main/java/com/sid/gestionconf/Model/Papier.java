package com.sid.gestionconf.Model;

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
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Set<Evaluation> evaluations;
	@OneToOne()
	private Track track;
	private String nom;
	private String description;
	private Boolean confirmer;
	@OneToOne()
	@JoinColumn(name = "idtopic", referencedColumnName = "id")
	private Topic topic;
	@Lob
	@Column(columnDefinition = "BLOB")
	private byte[] data;
	@Column(columnDefinition = "boolean default false")
	private Boolean deleted;
}
