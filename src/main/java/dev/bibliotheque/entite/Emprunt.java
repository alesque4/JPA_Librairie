package dev.bibliotheque.entite;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="emprunt")
public class Emprunt {
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="DATE_DEBUT", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Column(name="DATE_FIN", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	@Column(name="DELAI", nullable = false)
	private int delai;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	@ManyToMany
	@JoinTable(name  = "compo",
			joinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID")
			)
	private Set<Livre> livres;
	
	public String toString() {
		return "Emprunt id : "+id+" date_debut : "+dateDebut+" date_fin : "+dateFin+" delai : "+delai;
	}

	public Set<Livre> getLivres() {
		return livres;
	}
}
