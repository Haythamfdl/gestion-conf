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
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne()
	@JoinColumn(name = "idchair", referencedColumnName = "id")
	private Utilisateur chair;
	@ManyToOne()
	@JoinColumn(name = "idconference", referencedColumnName = "id")
	private Conference conference;
	@OneToMany (mappedBy = "session")
	private Set<Track> tracks;
	private Date datedeb;
	private Date datefin;
	private Long salle;
	private Boolean termine;
}