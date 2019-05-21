package dev.banque.model;

import javax.persistence.*;

@Entity
@Table(name="Virement")
public class Virement extends Operation {

	@Column(name="BENEFICIAIRE")
	private String beneficiaire;
}
