package dev.banque.entite;

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
	
	public Adresse() {super();}
	
	public Adresse(int numero, String rue, int codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
}
