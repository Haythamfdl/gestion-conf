package com.sid.gestionconf.Model;

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
	private String chambre;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idclient")
	private Utilisateur client;
	private Date datedeb;
	private Date datefin;
	private Boolean repas;
	@Column(columnDefinition = "boolean default false")
	private Boolean deleted;
}
