package dev.banque.entite;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="banque")
public class Banque {

	@Id
	private int id;
	
	@Column(name="NOM")
	private String nom;
	
	@OneToMany(mappedBy="banque")
	private Set<Client> clients;

	public Banque() { super();}
	
	public Banque(String nom, Set<Client> clients) {
		super();
		this.nom = nom;
		this.clients = clients;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
}
