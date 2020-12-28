package com.sid.gestionconf.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalleConference {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String etage;
	private int nbpersonne;
	private double prix;
	private Boolean disponible;
	@ManyToOne(fetch = FetchType.EAGER)
	private Hotel hotel;
}