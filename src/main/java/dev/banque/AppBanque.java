package dev.banque;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dev.banque.entite.*;

public class AppBanque {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque-jpa");
    	EntityManager em = entityManagerFactory.createEntityManager();
    	
    	Banque banque1;
    	Banque banque2;
    	Adresse adr1 = new Adresse(14, "rue du boulevard", 29200, "Brest");
    	Adresse adr2 = new Adresse(3, "boulevard des places", 69000, "Lyon");
    	Adresse adr3 = new Adresse(18, "place des rues", 35000, "Rennes");
    	Client cli1 = new Client("Le Chat", "Félix",  LocalDate.of(1970, 3, 3), adr1, null, null);
    	Banque banque1 = new Banque(nom, clients);
	

}
