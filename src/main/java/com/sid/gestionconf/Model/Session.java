package com.sid.gestionconf.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@ManyToOne()
	@JoinColumn(name = "idconference", referencedColumnName = "id")
	private Conference conference;
	@OneToMany (mappedBy = "session")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Set<Track> tracks;
	@OneToOne()
	@JoinColumn(name = "idchair", referencedColumnName = "id")
	private Utilisateur chair;
	private Date datedeb;
	private Date datefin;
	private String salle;
	@Column(columnDefinition = "boolean default false")
	private Boolean terminer;
	@Column(columnDefinition = "boolean default false")
	private Boolean deleted;
}
