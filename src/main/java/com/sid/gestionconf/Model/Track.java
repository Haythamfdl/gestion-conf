package com.sid.gestionconf.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date datedeb;
	private Date datefin;
	@OneToOne()
	@JoinColumn(name = "idpapier", referencedColumnName = "id")
	private Papier papier;
	private Boolean terminer;
	@ManyToOne()
	@JoinColumn(name = "idsession", referencedColumnName = "id")
	@JsonManagedReference
	private Session session;
	@Column(columnDefinition = "boolean default false")
	private Boolean deleted;
}
