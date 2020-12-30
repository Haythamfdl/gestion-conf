package com.sid.gestionconf.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conference {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne()
	@JoinColumn(name = "idorganisateur", referencedColumnName = "id")
	private Utilisateur organisateur;
	private String nom;
	private Date date;
	@OneToOne()
	@JoinColumn(name = "idhotel", referencedColumnName = "id")
	private Hotel hotel;
	private Long idsalle;
	@OneToMany (mappedBy = "conference")
	private Set<Session> sessions;
	private String categorie;
	private String sponsor;
	private String pageweb;
	private int maxpapier;
	private Date delaisoumission;
	private double prixticket;
	private int nticket;
	@Column(columnDefinition = "boolean default false")
	private Boolean terminer;
	@Column(columnDefinition = "boolean default false")
	private Boolean deleted;
}
