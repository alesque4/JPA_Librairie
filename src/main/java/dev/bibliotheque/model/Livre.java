package dev.bibliotheque.model;

import javax.persistence.*;

@Entity
@Table(name="livre")
public class Livre {
	
	@Id
	private int id;
	@Column(name="TITRE", nullable = false)
	private String titre;
	@Column(name="AUTEUR", nullable = false)
	private String auteur;

	public String toString() {
		return "Livre id : "+id+", titre : "+titre+", auteur : "+auteur;
	}
	
	
}
