package banque.entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="banque")
public class Banque {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="NOM")
	private String nom;
	
	@OneToMany(mappedBy="banque")
	private Set<Client> clients;

	public Banque() { 
		super();
		clients = new HashSet<Client>();
	}
	
	public Banque(String nom) { 
		super();
		clients = new HashSet<Client>();
		this.nom = nom;
	}
	
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

	public boolean addClient(Client c) {
		return clients.add(c);
	}
}
