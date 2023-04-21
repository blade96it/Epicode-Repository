package dao_package;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.Abbonamento;
import model.Autobus;
import model.BigliettoSingolo;
import model.ParcoMezzi;
import model.TappePercorse;
import model.Tram;
import model.Tratta;
import model.Utente;
import utils.JpaUtil;
import utils.StatoMezzo;

public class TrasportiDAO {

	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	
	public static void saveTratta (Tratta tratta) {		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(tratta);
			em.getTransaction().commit();
			System.out.println("Tratta aggiunta correttamente al database!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	}

	public static void saveMezzo (ParcoMezzi mezzo) {		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(mezzo);
			em.getTransaction().commit();
			System.out.println("Mezzo di trasporto aggiunto correttamente al database!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	}

	public static void obliteraBigliettoSingolo (long id_mezzo, long id_utente) {		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			ParcoMezzi mezzo = em.find(ParcoMezzi.class, id_mezzo);
			if(mezzo.getStato() == StatoMezzo.SERVIZIO) {
				Query q = em.createQuery("SELECT b from Biglietti b WHERE TYPE(b) = 'BigliettoSingolo'"
						+ " AND b.utente = '"+id_utente+"'").setMaxResults(1);
				BigliettoSingolo bigliettoObliterato = (BigliettoSingolo) q.getSingleResult();
				em.remove(bigliettoObliterato);
				System.out.println("Biglietto obliterato correttamente e cancellato dal database!");
			}
			else {
				System.out.println("Il mezzo è in manutenzione, non si può viaggiare!");
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

	public static void obliteraAbbonamento (long id_mezzo, long id_utente) {		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			ParcoMezzi mezzo = em.find(ParcoMezzi.class, id_mezzo);
			if(mezzo.getStato() == StatoMezzo.SERVIZIO) {
				Query q = em.createQuery("SELECT b from Biglietti b WHERE TYPE(b) = 'Abbonamento'"
						+ " AND b.utente = '"+id_utente+"'");
				Abbonamento abbonamentoObliterato = (Abbonamento) q.getSingleResult();
				if(abbonamentoObliterato.getData_attivazione_abbonamento() == null) {
					abbonamentoObliterato.setData_attivazione_abbonamento();
					em.merge(abbonamentoObliterato);
					System.out.println("Abbonamento obliterato e attivato correttamente. Scadrà il: " + abbonamentoObliterato.getData_scadenza_abbonamento());
				}
				else {
					LocalDate data = LocalDate.now();
					if(abbonamentoObliterato.getData_scadenza_abbonamento().isBefore(data)) {
						System.out.println("Il tuo abbonamento è scaduto, non puoi salire nel mezzo, acquistane uno nuovo!");
					}
					else {
						System.out.println("Abbonamento obliterato correttamente, scadrà il: " + abbonamentoObliterato.getData_scadenza_abbonamento());
					}
				}
				em.merge(abbonamentoObliterato);
			}
			else {
				System.out.println("Il mezzo è in manutenzione, non si può viaggiare!");
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

	public static void cambiaStatoMezzo (long id_mezzo) {		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			ParcoMezzi mezzo = em.find(ParcoMezzi.class, id_mezzo);
			if(mezzo.getStato() == StatoMezzo.SERVIZIO) {
				mezzo.setStato(StatoMezzo.MANUTENZIONE);
				System.out.println("Il mezzo è entrato in fase di manutenzione!");
			}
			else {
				mezzo.setStato(StatoMezzo.SERVIZIO);
				System.out.println("Il mezzo è rientrato in fase di servizio!");
			}
			em.merge(mezzo);
			em.getTransaction().commit();
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	}

	public static void percorriTratta (long id_mezzo, long durata_tratta) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			ParcoMezzi mezzo = em.find(ParcoMezzi.class, id_mezzo);
			if(mezzo.getStato() == StatoMezzo.SERVIZIO) { 
				TappePercorse tappa = new TappePercorse(mezzo, durata_tratta);
				em.persist(tappa);
				Query q = em.createQuery("SELECT t FROM Tratta t WHERE EXISTS (SELECT m FROM ParcoMezzi m"
						+ " WHERE t.id_tratta = m.tratta AND m.id_parco_mezzi = '"+id_mezzo+"')");
				Tratta tratta = (Tratta) q.getSingleResult();
				Query q1 = em.createQuery("SELECT p FROM TappePercorse p WHERE EXISTS (SELECT m FROM ParcoMezzi m"
						+ " WHERE p.mezzo = m.id_parco_mezzi AND m.tratta = '"+tratta.getId_tratta()+"')");
				List<TappePercorse> listaTappe = q1.getResultList();
				long tempoPercorso = 0;
				for(TappePercorse tappe : listaTappe) {
					tempoPercorso += tappe.getTempo_percorrenza();
				}
				long tempoMedio = tempoPercorso / listaTappe.size();
				tratta.setTempo_medio_percorrenza(tempoMedio);
				em.merge(tratta);
				System.out.println("Tratta completata! Aggiornato il tempo medio di percorrenza della tratta nel DB!");
			}
			else {
				System.out.println("Il mezzo è in manutenzione, non può viaggiare!");
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
