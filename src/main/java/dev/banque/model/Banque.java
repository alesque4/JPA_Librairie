package dev.banque.model;

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
}
