package dev.banque.entite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="AssuranceVie")
public class AssuranceVie extends Compte {

	@Column(name="TAUX")
	private double taux;

	@Column(name="DATE_FIN")
	@Temporal(TemporalType.DATE)
	private LocalDate dateFin;

	public AssuranceVie() {
		super();
	}
	
	public AssuranceVie(double taux, LocalDate dateFin) {
		super();
		this.taux = taux;
		this.dateFin = dateFin;
	}
}
