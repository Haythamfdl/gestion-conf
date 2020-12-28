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
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String adress;
	private String ville;
	@OneToMany(mappedBy = "hotel")
	private Set<Chambre> chambres;
	@OneToMany(mappedBy = "hotel")
	private Set<SalleConference> saleconf;

}