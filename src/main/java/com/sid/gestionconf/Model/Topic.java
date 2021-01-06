package com.sid.gestionconf.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String description;
	@OneToOne()
	@JoinColumn(name = "idconference", referencedColumnName = "id")
	private Conference conference;
	@Column(columnDefinition = "boolean default false")
	private Boolean deleted;
}
