package banque;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.entite.*;

public class AppBanque {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque-jpa");
    	EntityManager em = entityManagerFactory.createEntityManager();
    	
    	//Création de plusieurs Banques, Clients
    	Banque banque1 = new Banque("Crédit patate");
    	Banque banque2 = new Banque("Gimme all your money Bank inc.");
    	Adresse adr1 = new Adresse(14, "rue du boulevard", 29200, "Brest");
    	Adresse adr2 = new Adresse(3, "boulevard des places", 69000, "Lyon");
    	Adresse adr3 = new Adresse(18, "place des rues", 35000, "Rennes");
    	Client client1 = new Client("Le Chat", "Félix",  LocalDate.of(1970, 3, 3), adr1, banque1);
    	Client client2 = new Client("Michel-Jean", "Jean-Michel",  LocalDate.of(1980, 5, 8), adr2, banque1);
    	Client client3 = new Client("Norbert", "Robert",  LocalDate.of(1990, 2, 10), adr3, banque2);
    	/*
    	banque1.addClient(client1);
    	banque1.addClient(client2);
    	banque2.addClient(client3);
    	*/
    	
    	//Comptes
    	Compte compte1 = new AssuranceVie("1111", 200, 3.2, LocalDate.of(2030, 6, 30));
    	Compte compte2 = new Compte("2222", 500);
    	Compte compte3 = new Compte("3333", 1000);
    	Compte compte4 = new LivretA("4444", 2000, 1.15);
    	
    	client1.addCompte(compte1);
    	client1.addCompte(compte2);
    	client2.addCompte(compte2);
    	client3.addCompte(compte3);
    	client3.addCompte(compte4);
    	
    	compte1.addClient(client1);
    	compte2.addClient(client1);
    	compte2.addClient(client2);
    	compte3.addClient(client3);
    	compte4.addClient(client3);
    	
    	//Operations sur les comptes
    	Operation op1 = new Operation(LocalDateTime.of(2019, 6, 1, 12, 30), 15.0, "Big burger", compte2);
    	Operation op2 = new Operation(LocalDateTime.of(2019, 4, 1, 10, 20), 3.5, "planche à pain", compte2);
    	Operation op3 = new Operation(LocalDateTime.of(2019, 1, 1, 00, 01), 20.0, "Prelevement assurance", compte1);
    	Operation op4 = new Operation(LocalDateTime.of(2019, 3, 1, 19, 50), 500.0, "Loyer", compte3);
    	Operation op5 = new Virement(LocalDateTime.of(2018, 8, 3, 20, 00), 60.0, "Dette robert", compte3, "Robert");
    	Operation op6 = new Virement(LocalDateTime.of(2019, 9, 1, 8, 30), 0.22, "Interet Livret", compte4, "Gimme your money Bank inc.");

    	compte2.addOperation(op1);
    	compte2.addOperation(op2);
    	compte1.addOperation(op3);
    	compte3.addOperation(op4);
    	compte3.addOperation(op5);
    	compte4.addOperation(op6);
    	
    	System.out.println("Toutes les entitées ont été crées");
    	
    	//Envoi des objets dans la bdd
    	System.out.println("Début transaction");
    	EntityTransaction transaction = em.getTransaction();
    	transaction.begin();
    	
    	em.persist(banque1);
    	em.persist(banque2);
    	
    	em.persist(client1);
    	em.persist(client2);
    	em.persist(client3);
    	
    	em.persist(compte1);
    	em.persist(compte2);
    	em.persist(compte3);
    	em.persist(compte4);
    	
    	em.persist(op1);
    	em.persist(op2);
    	em.persist(op3);
    	em.persist(op4);
    	em.persist(op5);
    	em.persist(op6);
    	
    	transaction.commit();
    	em.close();
    	System.out.println("Fin transaction");
    	
	}
	

}
