package com.sid.gestionconf.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String address;
	private String ville;
	private String pays;
	@OneToMany(mappedBy = "hotel")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Set<Chambre> chambres;
	@OneToMany(mappedBy = "hotel")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Set<SalleConference> saleconf;
	@Column(columnDefinition = "boolean default false")
	private Boolean deleted;
}
