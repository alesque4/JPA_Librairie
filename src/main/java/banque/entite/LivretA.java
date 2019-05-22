package banque.entite;

import javax.persistence.*;

@Entity
@Table(name="LivretA")
public class LivretA extends Compte {

	@Column(name="TAUX")
	private double taux;
	
	public LivretA() {
		super();
	}

	public LivretA(String numero, double solde, double taux) {
		super(numero, solde);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
