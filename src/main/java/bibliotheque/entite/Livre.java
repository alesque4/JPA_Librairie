package bibliotheque.entite;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="livre")
public class Livre {
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="TITRE", nullable = false)
	private String titre;
	
	@Column(name="AUTEUR", nullable = false)
	private String auteur;
	
	@ManyToMany(mappedBy="livres")
	private Set<Emprunt> emprunts;

	public String toString() {
		return "Livre id : "+id+", titre : "+titre+", auteur : "+auteur;
	}
}
