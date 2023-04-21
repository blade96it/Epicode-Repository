package dao_package;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.Abbonamento;
import model.Biglietti;
import model.BigliettiEmessi;
import model.BigliettoSingolo;
import model.Distributori;
import model.DistributoriAutomatici;
import model.RivenditoriAutorizzati;
import model.Tessera;
import model.Utente;
import utils.JpaUtil;
import utils.TipologiaAbbonamento;

public class DistribuzioneDAO {

	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	
	public static void saveRivenditore (RivenditoriAutorizzati rivenditore) {		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(rivenditore);
			em.getTransaction().commit();
			System.out.println("Rivenditore aggiunto correttamente al database!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	}

	public static void saveDistributoreAutomatico (DistributoriAutomatici distributore) {		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(distributore);
			em.getTransaction().commit();
			System.out.println("Distributore automatico aggiunto correttamente al database!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static void richiediBigliettiRivenditore(long id_rivenditore) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			RivenditoriAutorizzati rivenditore = em.find(RivenditoriAutorizzati.class, id_rivenditore);
			List<Biglietti> lista;
			Query q = em.createQuery("SELECT b FROM BigliettoSingolo b").setMaxResults(50);
			Query q1 = em.createQuery("SELECT a FROM Abbonamento a WHERE a.tipologia_abbonamento = 'SETTIMANALE'").setMaxResults(5);
			Query q2 = em.createQuery("SELECT a FROM Abbonamento a WHERE a.tipologia_abbonamento = 'MENSILE'").setMaxResults(5);
			lista = q.getResultList();
			lista.addAll(q1.getResultList());
			lista.addAll(q2.getResultList());
			for(Biglietti biglietto : lista) {
				biglietto.setRivenditore(rivenditore);
				em.merge(biglietto);
			}	
			em.getTransaction().commit();
			System.out.println("Biglietti aggiunti correttamente al database!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	}

	public static void venditaBigliettiSingoliRivenditore(long id_rivenditore, long id_utente, int numeroBiglietti) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Utente utente = em.find(Utente.class, id_utente);
			Distributori distributore = em.find(Distributori.class, id_rivenditore);
			List<BigliettoSingolo> bigliettiDaAcquistare;
			Query q = em.createQuery("SELECT b FROM Biglietti b WHERE"
					+ " TYPE(b) = 'BigliettoSingolo' AND b.rivenditore = '"+id_rivenditore+"'").setMaxResults(numeroBiglietti);
			bigliettiDaAcquistare = q.getResultList();
			for(Biglietti biglietto : bigliettiDaAcquistare) {
				biglietto.setRivenditore(null);
				biglietto.setUtente(utente);
				em.merge(biglietto);
				BigliettiEmessi emissione = new BigliettiEmessi(distributore);
				em.persist(emissione);
			}	
			em.getTransaction().commit();
			System.out.println("Biglietti acquistati correttamente dal rivenditore!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static void venditaAbbonamentiSettimanaliRivenditore(long id_rivenditore, long id_utente) {
		boolean bool = verificaTessera(id_utente);
		if(bool) {
			EntityManager em = emf.createEntityManager();
			try {
				em.getTransaction().begin();
				Utente utente = em.find(Utente.class, id_utente);
				Distributori distributore = em.find(Distributori.class, id_rivenditore);
				Query q = em.createQuery("SELECT b FROM Biglietti b WHERE"
						+ " TYPE(b) = 'Abbonamento' AND b.tipologia_abbonamento = 'SETTIMANALE' AND b.rivenditore = '"+id_rivenditore+"'").setMaxResults(1);
				Abbonamento abbonamento = (Abbonamento) q.getSingleResult();
					abbonamento.setRivenditore(null);
					abbonamento.setUtente(utente);
					Abbonamento abbonamentoPassato = utente.getAbbonamento();
					if(abbonamentoPassato != null) {
						if(abbonamentoPassato.getUtente() != null) {
							em.remove(abbonamentoPassato);
						}
					}
					abbonamento.setNominativo(utente.getNome() + " " + utente.getCognome());
					utente.setAbbonamento(abbonamento);
					em.merge(abbonamento);
					BigliettiEmessi emissione = new BigliettiEmessi(distributore);
					em.persist(emissione);
				em.getTransaction().commit();
				System.out.println("Abbonamento settimanale acquistato correttamente dal rivenditore!");
			}
			catch (Exception ec) {
				em.getTransaction().rollback();
				System.out.println(ec.getMessage());
			} finally {
				em.close();
			}
		}
	}

	public static void venditaAbbonamentiMensiliRivenditore(long id_rivenditore, long id_utente) {
		boolean bool = verificaTessera(id_utente);
		if(bool) {
			EntityManager em = emf.createEntityManager();
			try {
				em.getTransaction().begin();
				Utente utente = em.find(Utente.class, id_utente);
				Distributori distributore = em.find(Distributori.class, id_rivenditore);
				Query q = em.createQuery("SELECT b FROM Biglietti b WHERE"
						+ " TYPE(b) = 'Abbonamento' AND b.tipologia_abbonamento = 'MENSILE' AND b.rivenditore = '"+id_rivenditore+"'").setMaxResults(1);
				Abbonamento abbonamento = (Abbonamento) q.getSingleResult();
					abbonamento.setRivenditore(null);
					abbonamento.setUtente(utente);
					Abbonamento abbonamentoPassato = utente.getAbbonamento();
					if(abbonamentoPassato != null) {
						if(abbonamentoPassato.getUtente() != null) {
							em.remove(abbonamentoPassato);
						}
					}
					abbonamento.setNominativo(utente.getNome() + " " + utente.getCognome());
					utente.setAbbonamento(abbonamento);
					em.merge(abbonamento);
					BigliettiEmessi emissione = new BigliettiEmessi(distributore);
					em.persist(emissione);
				em.getTransaction().commit();
				System.out.println("Abbonamento mensile acquistato correttamente dal rivenditore!");
			}
			catch (Exception ec) {
				em.getTransaction().rollback();
				System.out.println(ec.getMessage());
			} finally {
				em.close();
			}
		}
	}

	public static void venditaBigliettiSingoliDistributoreAutomatico (long id_dAutomatico, long id_utente, int numeroBiglietti) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Utente utente = em.find(Utente.class, id_utente);
			DistributoriAutomatici distributore = em.find(DistributoriAutomatici.class, id_dAutomatico);
			if(!distributore.isFuori_servizio()) {
			for(int i = 0; i < numeroBiglietti; i++) {
				BigliettoSingolo biglietto = new BigliettoSingolo();
				biglietto.setUtente(utente);
				BigliettiDAO.saveBigliettoSingolo(biglietto);
				BigliettiEmessi emissione = new BigliettiEmessi(distributore);
				em.persist(emissione);
			}
			em.getTransaction().commit();
			System.out.println("Biglietti singoli acquistati correttamente dal distributore automatico!");
			}
			else {
				System.out.println("Mi dispiace, questo distributore è fuori servizio!");
			}
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	}

	public static void venditaAbbonamentoMensileDistributoreAutomatico (long id_dAutomatico, long id_utente) {
		boolean bool = verificaTessera(id_utente);
		if(bool) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Utente utente = em.find(Utente.class, id_utente);
			DistributoriAutomatici distributore = em.find(DistributoriAutomatici.class, id_dAutomatico);
			if(!distributore.isFuori_servizio()) {
				Abbonamento abbonamento = new Abbonamento(utente.getNome() + " " + utente.getCognome(), TipologiaAbbonamento.MENSILE);
				abbonamento.setUtente(utente);
				Abbonamento abbonamentoPassato = utente.getAbbonamento();
				if(abbonamentoPassato != null) {
					if(abbonamentoPassato.getUtente() != null) {
						em.remove(abbonamentoPassato);
					}
				}
				utente.setAbbonamento(abbonamento);
				BigliettiDAO.saveAbbonamento(abbonamento);
				BigliettiEmessi emissione = new BigliettiEmessi(distributore);
				em.persist(emissione);
				em.getTransaction().commit();
				System.out.println("Abbonamento mensile acquistato correttamente dal distributore automatico!");
			}
			else {
				System.out.println("Mi dispiace, questo distributore è fuori servizio!");
			}
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
		}
	}

	public static void venditaAbbonamentoSettimanaleDistributoreAutomatico (long id_dAutomatico, long id_utente) {
		boolean bool = verificaTessera(id_utente);
		if(bool) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Utente utente = em.find(Utente.class, id_utente);
			DistributoriAutomatici distributore = em.find(DistributoriAutomatici.class, id_dAutomatico);
			if(!distributore.isFuori_servizio()) {
				Abbonamento abbonamento = new Abbonamento(utente.getNome() + " " + utente.getCognome(), TipologiaAbbonamento.SETTIMANALE);
				abbonamento.setUtente(utente);
				Abbonamento abbonamentoPassato = utente.getAbbonamento();
				if(abbonamentoPassato != null) {
					if(abbonamentoPassato.getUtente() != null) {
						em.remove(abbonamentoPassato);
					}
				}
				utente.setAbbonamento(abbonamento);
				BigliettiDAO.saveAbbonamento(abbonamento);
				BigliettiEmessi emissione = new BigliettiEmessi(distributore);
				em.persist(emissione);
				em.getTransaction().commit();
				System.out.println("Abbonamento settimanale acquistato correttamente dal distributore automatico!");
			}
			else {
				System.out.println("Mi dispiace, questo distributore è fuori servizio!");
			}
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
		}
	}
	
	public static boolean verificaTessera (long id_utente) {
		EntityManager em = emf.createEntityManager();
		boolean bool = false;
		LocalDate data = LocalDate.now();
		try {
			em.getTransaction().begin();
			Utente utente = em.find(Utente.class, id_utente);
			Tessera tessera = utente.getTessera();
			if(tessera != null) {
				System.out.println("Tessera presente con n° " + tessera.getId_tessera());
				if(tessera.getData_scadenza().isAfter(data)) {
					System.out.println("La tessera non è scaduta! Scadrà il: " + tessera.getData_scadenza());
					bool = true;
				}
				else {
					System.out.println("La tessera è scaduta!");
					bool = false;
				}
			}
			else {
				System.out.println("Questo utente non ha tessera!");
				bool = false;
			}
			em.getTransaction().commit();
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
			return bool;
		}
	}

}
