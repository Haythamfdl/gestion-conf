package com.sid.gestionconf.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chambre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String numero;
	private int nbpersonne;
	private double prix;
	private String type;
	private Boolean disponible;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idhotel")
	private Hotel hotel;
}
