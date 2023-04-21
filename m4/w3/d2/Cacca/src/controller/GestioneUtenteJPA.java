package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Utente;

public class GestioneUtenteJPA {	
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cacca");
	static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
		
		Utente u = new Utente();
		u.setNome("Mario");
		u.setCognome("Rossi");
		u.setEmail("m.rossi@example.com");
		
		//aggiungiUtente(u);
		
		Utente mioUtente = leggiUtente(1);
		System.out.println(mioUtente);
		
		//mioUtente.setEmail("mariolino.rossi@example.com");
		//modificaUtente(mioUtente);
		//System.out.println(mioUtente);
		
		eliminaUtente(mioUtente);
		
	}
	
	private static void aggiungiUtente(Utente u) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		System.out.println("Utente aggiunto nel DB!");
	}
	
	private static Utente leggiUtente(int id) {
		em.getTransaction().begin();
		Utente u = em.find(Utente.class, id);
		em.getTransaction().commit();
		return u;
	}
	
	private static void modificaUtente(Utente u) {
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		System.out.println("Utente modificato nel DB!");
	}

	private static void eliminaUtente(Utente u) {
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		System.out.println("Utente eliminato nel DB!");
	}
}
