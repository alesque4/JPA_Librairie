package dev.bibliotheque.entite;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="client")
public class Client {

	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="NOM", nullable=false)
	private String nom;
	
	@Column(name="PRENOM", nullable=false)
	private String prenom;
	
	@OneToMany(mappedBy="client")
	private Set<Emprunt> emprunts;
	
	public String toString() {
		return "Client id : "+id+" nom : "+nom+" prenom : "+prenom;
	}

	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}
}
