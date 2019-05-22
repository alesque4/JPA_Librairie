package dev.banque.entite;

import javax.persistence.*;

@Entity
@Table(name="LivretA")
public class LivretA extends Compte {

	@Column(name="TAUX")
	private double taux;
	
	public LivretA() {
		super();
	}

	public LivretA(double taux) {
		super();
		this.taux = taux;
	}

}
