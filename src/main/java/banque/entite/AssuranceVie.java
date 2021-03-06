package banque.entite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="AssuranceVie")
public class AssuranceVie extends Compte {

	@Column(name="TAUX")
	private double taux;

	@Column(name="DATE_FIN")
	private LocalDate dateFin;

	public AssuranceVie() {
		super();
	}
	
	public AssuranceVie(String numero, double solde, double taux, LocalDate dateFin) {
		super(numero, solde);
		this.taux = taux;
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
}
