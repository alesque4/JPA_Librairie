package banque.entite;

import javax.persistence.*;

@Embeddable
public class Adresse {

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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
}
