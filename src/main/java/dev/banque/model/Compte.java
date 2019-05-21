package dev.banque.model;

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

}
