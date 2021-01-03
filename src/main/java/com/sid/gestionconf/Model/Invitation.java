package com.sid.gestionconf.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invitation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne()
	@JoinColumn(name = "idinviteur", referencedColumnName = "id")

	private Utilisateur inviteur;
	@ManyToOne()
	@JoinColumn(name = "idinviter", referencedColumnName = "id")

	private Utilisateur inviter;
	@ManyToOne
	@JoinColumn(name = "idconference", referencedColumnName = "id")

	private Conference conference;
	@Column(columnDefinition = "boolean default false")
	private Boolean accepter;
	private String Message;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

}
