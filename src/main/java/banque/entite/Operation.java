package banque.entite;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="operation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="DATE")
	private LocalDateTime date;
	
	@Column(name="MONTANT")
	private double montant;
	
	@Column(name="MOTIF")
	private String motif;

	@ManyToOne
	@JoinColumn(name="ID_COM")
	private Compte compte;

	public Operation() {
		super();
	}

	public Operation(LocalDateTime date, double montant, String motif, Compte compte) {
		super();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.compte = compte;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}
}
