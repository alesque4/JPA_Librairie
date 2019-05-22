package banque.entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="NUMERO", nullable = false)
	private String numero;
	
	@Column(name="SOLDE", nullable = false)
	private double solde;
	
	@ManyToMany
	@JoinTable(name="CLIENTS_COMPTES",
		joinColumns=@JoinColumn(name="ID_COM", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="ID_CLI", referencedColumnName="id"))
	private Set<Client> clients;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;

	public Compte() {
		super();
		clients = new HashSet<Client>();
		operations = new HashSet<Operation>();
	}

	public Compte(String numero, double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
		clients = new HashSet<Client>();
		operations = new HashSet<Operation>();
	}
	
	public Compte(String numero, double solde, Set<Client> clients, Set<Operation> operations) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.clients = clients;
		this.operations = operations;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public boolean addClient(Client c) {
		return clients.add(c);
	}
	
	public boolean addOperation(Operation o) {
		return operations.add(o);
	}

}
