package dao_package;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Abbonamento;
import model.BigliettoSingolo;
import utils.JpaUtil;

public class BigliettiDAO {

	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	
	public static void saveBigliettoSingolo (BigliettoSingolo biglietto) {		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(biglietto);
			em.getTransaction().commit();
			System.out.println("Biglietto aggiunto correttamente al database!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	}

	public static void saveAbbonamento (Abbonamento abbonamento) {		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(abbonamento);
			em.getTransaction().commit();
			System.out.println("Abbonamento aggiunto correttamente al database!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	}
}
