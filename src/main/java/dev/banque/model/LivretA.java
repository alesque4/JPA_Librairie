package dev.banque.model;

import javax.persistence.*;

@Entity
@Table(name="LivretA")
public class LivretA extends Compte {
	
	@Column(name="TAUX")
	private double taux;

}
