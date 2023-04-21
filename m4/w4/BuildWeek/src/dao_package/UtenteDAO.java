package dao_package;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.Abbonamento;
import model.Biglietti;
import model.Tessera;
import model.Utente;
import utils.JpaUtil;

public class UtenteDAO {

	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	
	public static void saveUtente (Utente utente) {		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(utente);
			em.getTransaction().commit();
			System.out.println("Utente aggiunto correttamente al database!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static void aggiungiTesseraUtente (long id_utente, long id_tessera) {		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Utente utente = em.find(Utente.class, id_utente);
			Tessera tessera = new Tessera();
			em.persist(tessera);
			tessera = em.find(Tessera.class, id_tessera);
			utente.setTessera(tessera);
			em.merge(utente);
			em.getTransaction().commit();
			System.out.println("Utente aggiornato e tessera aggiunta nel database!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	}

	public static void rimuoviUtente(long id_utente) {
		EntityManager em = emf.createEntityManager();	
		try {
			em.getTransaction().begin();
			Utente utente = em.find(Utente.class, id_utente);
			Query q = em.createQuery("SELECT b FROM Biglietti b WHERE EXISTS (SELECT u FROM Utente u"
					+ " WHERE b.utente = u.id_utente AND u.id_utente = '"+id_utente+"')");
			List<Biglietti> listaBiglietti = q.getResultList();
			for(Biglietti biglietto : listaBiglietti) {
				em.remove(biglietto);
			}
			em.remove(utente);
			em.getTransaction().commit();
			System.out.println("Utente e relativa tessera rimossi correttamente dal database! Rimossi inoltre anche i biglietti!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	} 

	public static void verificaAbbonamentodaTessera (long id_tessera) {
		EntityManager em = emf.createEntityManager();	
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("SELECT u FROM Utente u WHERE EXISTS"
					+ " (SELECT t FROM Tessera t WHERE t.id_tessera = u.tessera"
					+ " AND t.id_tessera = '"+id_tessera+"')");
			Utente utente = (Utente) q.getSingleResult();		
			if(utente != null) {
				Query q1 = em.createQuery("SELECT b FROM Biglietti b WHERE EXISTS"
						+ " (SELECT u FROM Utente u WHERE u.abbonamento = b.id_biglietto"
						+ " AND u.id_utente = '"+utente.getId_utente()+"')");
				Abbonamento abbonamento = (Abbonamento) q1.getSingleResult();
				if(abbonamento.getData_scadenza_abbonamento() != null) {
					LocalDate data = LocalDate.now();
					if(abbonamento.getData_scadenza_abbonamento().isAfter(data)) {
						System.out.println("L'abbonamento è ancora valido! Scadrà il: " + abbonamento.getData_scadenza_abbonamento());
					}
					else {
						System.out.println("Mi dispiace, l'abbonamento è scaduto, acquistane uno nuovo!");
					}
				}
				else {
					if(abbonamento == null) {
					System.out.println("Questo utente non possiede un abbonamento!");
					}
					else {
						System.out.println("L'abbonamento è presente ma non è stato attivato, obliteralo per poterlo attivare!");
					}
				}
			}
			em.getTransaction().commit();
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	}
}
