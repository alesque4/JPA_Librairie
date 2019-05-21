package dev.banque.model;

import javax.persistence.*;

@Entity
@Table(name="Adresse")
public class Adresse {

	@Id
	private int id;
	
	@Column(name="NUMERO", nullable=false)
	private int numero;
	
	@Column(name="RUE", nullable=false)
	private String rue;
	
	@Column(name="CODE_POSTAL", nullable=false)
	private int codePostal;
	
	@Column(name="VILLE", nullable=false)
	private String ville;
}
