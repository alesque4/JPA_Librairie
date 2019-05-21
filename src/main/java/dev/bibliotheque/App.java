package dev.bibliotheque;

import javax.persistence.*;

import dev.bibliotheque.model.Client;
import dev.bibliotheque.model.Emprunt;
import dev.bibliotheque.model.Livre;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque-jpa");
    	EntityManager em = entityManagerFactory.createEntityManager();
    	TypedQuery<Livre> queryLivre = null;
    	String titreRecherche = "Guerre et paix";
    	
    	//---------- TP1 ----------
    	
    	//Recherche avec find
    	Livre livre = em.find(Livre.class, 1);
    	
    	System.out.println("find : "+livre);
    	
    	//Recherche avec query
    	queryLivre = em.createQuery("select l from Livre l where l.titre = :titre", Livre.class);
    	queryLivre.setParameter("titre", titreRecherche);
    	livre = queryLivre.getResultList().get(0);
    	
    	System.out.println("query : "+livre);
    	
    	//---------- TP2 ----------
    	TypedQuery<Emprunt> queryEmprunt = null;
    	TypedQuery<Client> queryClient = null;
    	Emprunt emprunt = null;
    	Client client = null;
    	int idEmprunt = 1;
    	int idClient = 1;
    	
    	
    	//Requete pour récupérer un emprunt et les livres associés
    	queryEmprunt = em.createQuery("select e from Emprunt e where id=:id", Emprunt.class);
    	queryEmprunt.setParameter("id", idEmprunt);
    	emprunt = queryEmprunt.getResultList().get(0);
    	
    	System.out.println("emp : "+emprunt);
    	
    	for(Livre l : emprunt.getLivres()) {
    		System.out.println(l);
    	}
    	
    	//Réaliser une requête qui permet d’extraire tous les emprunts d’un client donné.
    	queryClient = em.createQuery("select e from Client e where id=:id", Client.class);
    	queryClient.setParameter("id", idClient);
    	client = queryClient.getResultList().get(0);
    	
    	System.out.println("Client : "+client);
    	System.out.println("Emprunts du client avec l'id "+idClient+" : \n"+client.getEmprunts());
    	
    }
}
