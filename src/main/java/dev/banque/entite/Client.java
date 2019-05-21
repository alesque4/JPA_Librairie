package dev.banque.entite;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	private int id;

	@Column(name="NOM", nullable=false)
	private String nom;
	
	@Column(name="PRENOM",  nullable=false)
	private String prenom;
	
	@Column(name="DATE_NAISSANCE",  nullable=false)
	@Temporal(TemporalType.DATE)
	private LocalDate dateNaissance;

	@OneToOne
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name="ID_BANQUE")
	private Banque banque;
	
	@ManyToMany(mappedBy="clients")
	private Set<Compte> comptes;
	
	public Client() {
		super();
	}

	public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque,
			Set<Compte> comptes) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.banque = banque;
		this.comptes = comptes;
	}
	
	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}
}
