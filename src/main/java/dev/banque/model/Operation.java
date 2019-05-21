package dev.banque.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="operation")
public class Operation {
	
	@Id
	private int id;
	
	@Column(name="DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime date;
	
	@Column(name="MONTANT")
	private double montant;
	
	@Column(name="MOTIF")
	private String motif;

	@ManyToOne
	@JoinColumn(name="ID_COM")
	private Compte compte;
}
