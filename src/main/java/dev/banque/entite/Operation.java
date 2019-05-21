package dev.banque.entite;

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

	public Operation() {
		super();
	}

	public Operation(LocalDateTime date, double montant, String motif, Compte compte) {
		super();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.compte = compte;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
}
