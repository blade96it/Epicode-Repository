package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import utils.Evento;
import utils.JpaUtil;

public class EventoDAO {
	
	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	
	public static void save (Evento evento) {		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(evento);
			em.getTransaction().commit();
			System.out.println("Evento aggiunto correttamente al database!");
		} finally {
			em.close();
		}
	}
	
	@SuppressWarnings("finally")
	public static Evento getByID(Integer id) {
		EntityManager em = emf.createEntityManager();
		Evento evento = new Evento();
		try {
			em.getTransaction().begin();
			evento = em.find(Evento.class, id);
			em.getTransaction().commit();
			System.out.println("Evento trovato correttamente!");
		} finally {
			em.close();
			return evento;
		}
	}
	
	public static void delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Evento evento = em.find(Evento.class, id);
			em.remove(evento);
			em.getTransaction().commit();
			System.out.println("Evento eliminato correttamente al database!");
		} finally {
			em.close();
		}
	}
	
	public static void refresh(Evento evento) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.refresh(evento);
			em.getTransaction().commit();
			System.out.println("Evento refreshato correttamente dal database!");
		} finally {
			em.close();
		}
	}
	
}
