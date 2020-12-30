package com.sid.gestionconf.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne()
	@JoinColumn(name = "idhotel")
	private Hotel hotel;
	private Long idchambre;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idclient")
	@JsonManagedReference
	private Utilisateur client;
	private Date datedeb;
	private Date datefin;
	private Boolean repas;
	private double prix;
	@Column(columnDefinition = "boolean default false")
	private Boolean deleted;
}
