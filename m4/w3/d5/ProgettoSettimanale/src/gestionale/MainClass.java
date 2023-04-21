//IMPORTANTE!!! NEL MIO DATABASE LA PASSWORD E' epicode QUINDI NEL PERSISTANCE SI DOVRA' CAMBIARE LA PASSWORD!!!

package gestionale;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.Catalogo;
import model.Libro;
import model.Periodicità;
import model.Prestito;
import model.Rivista;
import model.Utente;
import utils.JpaUtil;

public class MainClass {

	//ISTANZIO L'ENTITYMANAGERFACTORY DEFINITO COME CLASS NEL PACK UTILS
	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	
	public static void main(String[] args) {
		
		//AGGIUNGO DIVERSI ELEMENTI AL CATALOGO DEL DATABASE  - DECOMMENTARE I METODI AGGIUNGIALCATALOGO PER POTERLI AGGIUNGERE NUOVAMENTE
		Libro libro1 = new Libro("Il Signore degli Anelli", 1955, 1264, "J R.R. Tolkien", "Fantasy");
		Rivista rivista1 = new Rivista("Focus", 2023, 124, Periodicità.MENSILE);
		Libro libro2 = new Libro("Una Tempesta di Spade", 2000, 1224, "George R.R. Martin", "Fantasy");
		Rivista rivista2 = new Rivista("La Settimana Enigmistica", 2023, 54, Periodicità.SETTIMANALE);
		Libro libro3 = new Libro("Shining", 1977, 592, "Stephen King", "Thriller");
		Rivista rivista3 = new Rivista("Ciak Magazine", 2023, 78, Periodicità.MENSILE);
		Libro libro4 = new Libro("Origin", 2017, 560, "Dan Brown", "Thriller");
		Rivista rivista4 = new Rivista("Giallo Zafferano", 2023, 89, Periodicità.SETTIMANALE);
		Libro libro5 = new Libro("It", 1986, 1216, "Stephen King", "Horror");
		Rivista rivista5 = new Rivista("Antropologia", 2022, 203, Periodicità.SEMESTRALE);
		//aggiungiAlCatalogo(libro1);
		//aggiungiAlCatalogo(rivista1);
		//aggiungiAlCatalogo(libro2);
		//aggiungiAlCatalogo(rivista2);
		//aggiungiAlCatalogo(libro3);
		//aggiungiAlCatalogo(rivista3);
		//aggiungiAlCatalogo(libro4);
		//aggiungiAlCatalogo(rivista4);
		//aggiungiAlCatalogo(libro5);
		//aggiungiAlCatalogo(rivista5);
		
		//AGGIUNGO DIVERSI UTENTI AL DATABASE  - DECOMMENTARE I METODI AGGIUNTIUTENTE PER POTERLI AGGIUNGERE NUOVAMENTE
		Utente utente1 = new Utente("Manuel", "Gadau", "1996-02-12");
		Utente utente2 = new Utente("Pinco", "Pallino", "2003-03-12");
		Utente utente3 = new Utente("Lucia", "Giggia", "1987-12-05");
		Utente utente4 = new Utente("Geronimo", "Stilton", "1932-08-27");
		Utente utente5 = new Utente("Luca", "Argentero", "1980-05-10");
		//aggiungiUtente(utente1);
		//aggiungiUtente(utente2);
		//aggiungiUtente(utente3);
		//aggiungiUtente(utente4);
		//aggiungiUtente(utente5);
		
		//RECUPERO GLI UTENTI SALVATI NEL DATABASE PER POTERLI UTILIZZARE NELL'INSERIMENTO DEL PRESTITO
		utente1 = recuperaUtente(1);
		utente2 = recuperaUtente(2);
		utente3 = recuperaUtente(3);
		utente4 = recuperaUtente(4);
		utente5 = recuperaUtente(5);
		
		//STESSA COSA PER GLI ELEMENTI DEL CATALOGO. (Mi rendo conto sia un pò macchinoso, potevo anche usare una lista effettivamente).
		Catalogo catalogo = recuperaElementoDaCatalogo(1);
		Catalogo catalogo1 = recuperaElementoDaCatalogo(2);
		Catalogo catalogo2 = recuperaElementoDaCatalogo(3);
		Catalogo catalogo3 = recuperaElementoDaCatalogo(4);
		Catalogo catalogo4 = recuperaElementoDaCatalogo(5);
		Catalogo catalogo5 = recuperaElementoDaCatalogo(6);
		Catalogo catalogo6 = recuperaElementoDaCatalogo(7);
		Catalogo catalogo7 = recuperaElementoDaCatalogo(8);
		Catalogo catalogo8 = recuperaElementoDaCatalogo(9);
		Catalogo catalogo9 = recuperaElementoDaCatalogo(10);
		
		//CON QUESTI PRESTITI DECIDO QUALI UTENTI DECIDONO DI RICHIEDERLO E QUALE ELEMENTO DEL CATALOGO SARA' PRESO IN PRESTITO.
		Prestito prestito1 = new Prestito(utente1, catalogo7);
		Prestito prestito2 = new Prestito(utente1, catalogo6);
		Prestito prestito3 = new Prestito(utente3, catalogo9);
		Prestito prestito4 = new Prestito(utente1, catalogo7);
		Prestito prestito5 = new Prestito(utente5, catalogo2);
		Prestito prestito6 = new Prestito(utente2, catalogo3);
		
		//AGGIUNGO DIVERSI PRESTITI AL DATABASE  - DECOMMENTARE I METODI AGGIUNGIPRESTITO PER POTERLI AGGIUNGERE NUOVAMENTE.
		//IMPORTANTE!!! PER FAR SI CHE NON VENGA AGGIUNTO UN PRESTITO CON UN CODICE ISBN GIA' PRESENTE E' NECESSARIO MANUALMENTE INSERIRE UN COSNTRAINT UNIQUE
		//ALLA TABELLA PRESTITO DIRETTAMENTE SU PGADMIN. HO PROVATO IN ALTRI 123124421 MODI DIRETTAMENTE CON JPA MA NON CI SONO RIUSCITO!
		//aggiungiPrestito(prestito1);
		//aggiungiPrestito(prestito2);
		//aggiungiPrestito(prestito3);
		
		//QUESTO COMANDO DARA' ERRORE SE VERRANNO GENERATI I PRECEDENTI PRESTITI
		//aggiungiPrestito(prestito4);
		
		//aggiungiPrestito(prestito5);
		//aggiungiPrestito(prestito6);
		
		//IN QUESTO MODO POSSO RECUPERARMI TUTTI GLI UTENTI PRESENTI NEL DATABASE ATTRAVERSO UNA NAMEDQUERY
		//List<Utente> listaUtentiDB = recuperaUtenti();
		//for(Utente u : listaUtentiDB) {
		//	System.out.println(u.toString());
		//}
		
		System.out.println("Filtraggio per ISBN");
		ricercaPerISBN(1);
		System.out.println("Filtraggio per Anno Pubblicazione");
		ricercaPerAnnoPubblicazione(2023);
		System.out.println("Filtraggio per Autore");
		ricercaPerAutore("Stephen King");
		System.out.println("Filtraggio per Titolo");
		ricercaPerTitolo("in");
		System.out.println("Filtraggio di elementi del Catalogo attualmente in prestito ad un determinato cliente");
		ricercaPrestitiPerTessera(1);
		
		//IN QUANTO LE DATE CHE VENGONO GENERATE NEI PRESTITI SONO QUELLE ATTUALI ALLA CREAZIONE DELL'OGGETTO, LA SCADENZA DELLE STESSE SARA' DIRETTAMENTE 30 GIORNI DOPO.
		//HO PENSATO PER L'APPUNTO DI CREARE, GIUSTO PER QUESTO ESERCIZIO, UNA LOCALDATE PERSONALIZZATA COSI' CHE I PRESTITI RISULTINO SCADUTI. UTILIZZANDO
		//UNA LOCALDATE PRIMA DELLA SCADENZA INVECE NON VERRA' STAMPATO NESSUN PRESTITO.
		//NEL METODO RICERCAPRESTITISCADUTI INVECE MI SONO ASSICURATO CHE SE NELLA DATA DELLA RESTITUIZIONE EFFETTIVA IL VALORE E' NULL, E QUINDI IL PRESTITO
		//NON E' MAI STATO RESTITUITO, ALLORA IL PARAGONE SARA' VALIDO E QUINDI IL PRESTITO E' SIA SCADUTO CHE NON ANCORA RESTITUITO.
		LocalDate dataInput = LocalDate.parse("2023-04-08");
		System.out.println("Filtraggio per prestiti scaduti che ancora non sono stati restituiti");
		ricercaPrestitiScaduti(dataInput);
	}

	public static void aggiungiAlCatalogo(Catalogo elemento) {
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(elemento);
			em.getTransaction().commit();
			System.out.println("Elemento aggiunto correttamente al database!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static void rimuoviDalCatalogo(long isbn) {
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			Catalogo elemento = em.find(Catalogo.class, isbn);
			em.remove(elemento);
			em.getTransaction().commit();
			System.out.println("Elemento rimosso correttamente dal database!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	} 

	public static void aggiungiUtente(Utente utente) {
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

	public static void aggiungiPrestito(Prestito prestito) {
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(prestito);
			em.getTransaction().commit();
			System.out.println("Prestito aggiunto correttamente al database!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("finally")
	public static Utente recuperaUtente(long numeroTessera) {
		EntityManager em = emf.createEntityManager();
		Utente utente = new Utente();
		
		try {
			em.getTransaction().begin();
			utente = em.find(Utente.class, numeroTessera);
			em.getTransaction().commit();
			System.out.println("Utente recuperato correttamente dal database!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
			return utente;
		}
	} 

	@SuppressWarnings("finally")
	public static Catalogo recuperaElementoDaCatalogo(long isbn) {
		EntityManager em = emf.createEntityManager();
		Catalogo elemento = new Catalogo();
		
		try {
			em.getTransaction().begin();
			elemento = em.find(Catalogo.class, isbn);
			em.getTransaction().commit();
			System.out.println("Elemento del catalogo recuperato correttamente dal database!");
		}
		catch (Exception ec) {
			em.getTransaction().rollback();
			System.out.println(ec.getMessage());
		} finally {
			em.close();
			return elemento;
		}
	}

	public static List<Utente> recuperaUtenti () {
		EntityManager em = emf.createEntityManager();
		Query q = em.createNamedQuery("Utente.findAll");
		return q.getResultList();
	}
	
	public static void ricercaPerISBN (long isbn) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT a FROM Catalogo a WHERE a.codiceISBN = '"+isbn+"'");
		Catalogo elemento = (Catalogo) q.getSingleResult();
			System.out.println(elemento.getCodiceISBN() + " - " + elemento.getTitolo());
	}

	public static void ricercaPerAnnoPubblicazione (int anno) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT a FROM Catalogo a WHERE a.annoPubblicazione = '"+anno+"'");
		List<Catalogo> lista = q.getResultList();
		for(Catalogo elemento : lista) {
			System.out.println(elemento.getCodiceISBN() + " - " + elemento.getTitolo());
		}
	}

	public static void ricercaPerAutore (String autore) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT a FROM Catalogo a WHERE a.autore = '"+autore+"'");
		List<Catalogo> lista = q.getResultList();
		for(Catalogo elemento : lista) {
			System.out.println(elemento.getCodiceISBN() + " - " + elemento.getTitolo());
		}
	}
	
	public static void ricercaPerTitolo (String titolo) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT a FROM Catalogo a WHERE a.titolo LIKE '%"+titolo+"%'");
		List<Catalogo> lista = q.getResultList();
		for(Catalogo elemento : lista) {
			System.out.println(elemento.getCodiceISBN() + " - " + elemento.getTitolo());
		}
	}

	public static void ricercaPrestitiPerTessera (long numeroTessera) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT c FROM Catalogo c WHERE EXISTS (SELECT p FROM Prestito p "
				+ "WHERE p.elementoPrestato = c.codiceISBN AND p.utente= '"+numeroTessera+"')");
		List<Catalogo> lista = q.getResultList();
		for(Catalogo elemento : lista) {
			System.out.println(elemento.getCodiceISBN() + " - " + elemento.getTitolo());
		}
	}

	public static void ricercaPrestitiScaduti(LocalDate data) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT p FROM Prestito p WHERE "
				+ "(p.DataRestituizionePrevista < '"+data+"' AND p.DataRestituizioneEffetiva IS NULL)");
		List<Prestito> lista = q.getResultList();
		for(Prestito elemento : lista) {
			System.out.println(elemento.getElementoPrestato().getCodiceISBN() + " - " + elemento.getElementoPrestato().getTitolo());
		}
	}
}
