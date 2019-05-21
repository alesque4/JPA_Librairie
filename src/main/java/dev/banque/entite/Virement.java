package dev.banque.entite;

import javax.persistence.*;

@Entity
@Table(name="virement")
public class Virement extends Operation {

	@Column(name="BENEFICIAIRE")
	private String beneficiaire;

	public Virement() {
		super();
	}

	public Virement(String beneficiaire) {
		super();
		this.beneficiaire = beneficiaire;
	}
}
