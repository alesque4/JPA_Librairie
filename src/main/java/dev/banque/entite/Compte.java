package dev.banque.entite;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="compte")
public class Compte {
	
	@Id
	private int id;
	
	@Column(name="NUMERO", nullable = false)
	private String numero;
	
	@Column(name="SOLDE", nullable = false)
	private double solde;
	
	@ManyToMany
	@JoinTable(name="CLIENTS_COMPTES",
		joinColumns=@JoinColumn(name="ID_COM", referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="ID_CLI", referencedColumnName="ID"))
	private Set<Client> clients;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;

	public Compte() {
		super();
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

}
