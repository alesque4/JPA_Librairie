package banque.entite;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="Virement")
public class Virement extends Operation {

	@Column(name="BENEFICIAIRE")
	private String beneficiaire;

	public Virement() {
		super();
	}

	public Virement(LocalDateTime date, double montant, String motif, Compte compte, String beneficiaire) {
		super(date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
}
