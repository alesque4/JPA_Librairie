package dev.bibliotheque;

import javax.persistence.*;

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
    	TypedQuery<Livre> query = null;
    	String titreRecherche = "Guerre et paix";
    	
    	//Recherche avec find
    	Livre livre = em.find(Livre.class, 1);
    	
    	System.out.println("find : "+livre);
    	
    	//Recherche avec query
    	query = em.createQuery("select l from Livre l where l.titre = '"+titreRecherche+"'", Livre.class);
    	livre = query.getResultList().get(0);
    	
    	System.out.println("query : "+livre);
    }
}
