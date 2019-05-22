package banque.entite;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue
	private int id;

	@Column(name="NOM", nullable=false)
	private String nom;
	
	@Column(name="PRENOM",  nullable=false)
	private String prenom;
	
	@Column(name="DATE_NAISSANCE",  nullable=false)
	private LocalDate dateNaissance;

	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name="ID_BANQUE")
	private Banque banque;
	
	@ManyToMany(mappedBy="clients")
	private Set<Compte> comptes;
	
	public Client() {
		super();
		comptes = new HashSet<Compte>();
	}

	public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.banque = banque;
		comptes = new HashSet<Compte>();
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public boolean addCompte(Compte c) {
		return comptes.add(c);
	}
}
