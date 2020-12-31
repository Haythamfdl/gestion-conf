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
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Utilisateur premierauteur;
	@OneToOne()
	@JoinColumn(name = "idauteur", referencedColumnName = "id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Utilisateur auteur;
	@OneToOne()
	@JoinColumn(name = "idpresentateur", referencedColumnName = "id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Utilisateur presentateur;
	@OneToMany(mappedBy = "papier")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Set<Evaluation> evaluations;
	private String nom;
	private String description;
	private Boolean confirmer;
	@OneToOne()
	@JoinColumn(name = "idtopic", referencedColumnName = "id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Topic topic;
	@Lob
	@Column(columnDefinition = "BLOB")
	private byte[] data;
	@Column(columnDefinition = "boolean default false")
	private Boolean deleted;
}
