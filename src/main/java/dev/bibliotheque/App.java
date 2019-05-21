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
    	Query query = null;
    	String titreRecherche = "Guerre et paix";
    	
    	//Recherche avec find
    	Livre livre = em.find(Livre.class, 3);
    	
    	System.out.println("find : "+livre);
    	
    	//Recherche avec query
    	query = em.createQuery("select * from livre where titre = \""+titreRecherche+"\"");
    	livre = (Livre) query.getResultList().get(0);
    }
}
