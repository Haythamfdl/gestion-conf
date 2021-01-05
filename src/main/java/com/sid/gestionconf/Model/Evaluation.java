package com.sid.gestionconf.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne()
	@JoinColumn(name = "idpauteur", referencedColumnName = "id")
	private Utilisateur evaluateur;
	@ManyToOne()
	@JoinColumn(name = "idpapier", referencedColumnName = "id")
	private Papier papier;
	private String revue;
	private String commentaire;
	private String note;
	private Date date;
	@Column(columnDefinition = "boolean default false")
	private Boolean deleted;
}
