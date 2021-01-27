package com.sid.gestionconf.Model;

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
	@Column(columnDefinition = "boolean default false")
	private Boolean deleted;
}
