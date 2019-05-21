package dev.banque.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	private int id;
	
	@Column(name="NOM", nullable=false)
	private String nom;
	
	@Column(name="PRENOM",  nullable=false)
	private String prenom;
	
	@Column(name="DATE_NAISSANCE",  nullable=false)
	private LocalDate dateNaissance;
	
	@OneToOne
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name="ID_BANQUE")
	private Banque banque;
}
