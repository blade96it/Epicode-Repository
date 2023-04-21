//IMPORTANTE!!! NEL MIO DATABASE LA PASSWORD E' epicode QUINDI NEL PERSISTANCE SI DOVRA' CAMBIARE LA PASSWORD!!!
package main_package;

import javax.persistence.EntityManagerFactory;

import dao_package.BigliettiDAO;
import dao_package.DistribuzioneDAO;
import dao_package.TrasportiDAO;
import dao_package.UtenteDAO;
import model.Abbonamento;
import model.Autobus;
import model.BigliettoSingolo;
import model.DistributoriAutomatici;
import model.ParcoMezzi;
import model.RivenditoriAutorizzati;
import model.Tram;
import model.Tratta;
import model.Utente;
import utils.JpaUtil;
import utils.TipologiaAbbonamento;

/////////////////////////////LEGENDA////////////////////////////////
// <--- con i due slash indico esclusivamente i metodi commentati da decommentare per poterli provare. I parametri in ingresso possono essere cambiati.
/**/     //<---con il commento multilinea includo esclusivamente le spiegazioni dei metodi e del funzionamento generale.

public class MainClass {

	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	
	public static void main(String[] args) {
		
		/*L'idea è quella di creare, e di salvare sul database, degli utenti privi di tessera, come una normale registrazione ad un'app dei trasporti pubblici
		locale. Una volta che il cliente si sarà registrato avrà la possibilità di creare la sua tessera personale, per poter così acquistare un abbonamento.*/
		
		/*Con questa variabile idTessera creo dinamicamente degli ID di controllo della tessera. Tale variabile DEVE aumentare ogni qualvolta verrà richiamato
		il metodo aggiungiTesseraUtente.*/
		long idTessera = 1;
		
		//Creo l'istanza o più istanze, in locale, di un utente da salvare poi successivamente nel database.
		Utente utente1 = new Utente("Manuel", "Gadau", "blade96it", "password1", "gadaumanuel@gmail.com");
		Utente utente2 = new Utente("Manuel2", "Gadau2", "blade96it2", "password2", "2gadaumanuel@gmail.com");
		Utente utente3 = new Utente("Manuel3", "Gadau3", "blade96it3", "password3", "3gadaumanuel@gmail.com");
		
		/*Con il metodo saveUtente effettuo il semplice PERSIST nel DB dell'istanza locale creata precedentemente.*/
//		UtenteDAO.saveUtente(utente1);
//		UtenteDAO.saveUtente(utente2);
//		UtenteDAO.saveUtente(utente3);
		
		/*Con il metodo aggiungiTesseraUtente ricevo in ingresso due parametri. Il primo rispecchia l'ID dell'utente da trovare nel database e il secondo riguarda
		l'ID della tessera. All'interno di questo metodo creo una tessera dinamicamente, la salvo nel DB e dopodichè la setto all'interno dell'utente e salvo
		tutte le modifiche con un MERGE all'interno del DB*/
//		UtenteDAO.aggiungiTesseraUtente(1, idTessera);
//		idTessera++;
//		UtenteDAO.aggiungiTesseraUtente(3, idTessera);
//		idTessera++;
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/*Per quanto riguarda i rivenditori autorizzati l'idea è di farli funzionare come delle vere e proprie edicole o tabacchini. In sostanza, vengono prodotti
		in azienda un tot preciso di biglietti singoli e di abbonamenti, sia settimanali che mensili. Essi vengono spediti la mattina ai rivenditori così che nella
		giornata essi possano essere venduti ai clienti.*/
		
		/*Con questi cicli si creano 100 nuovi biglietti singoli, 20 abbonamenti settimanali e 20 abbonamenti mensili, tutti con il proprio id univoco.*/
//		for(int i = 0; i < 100; i++) {
//			BigliettoSingolo biglietto = new BigliettoSingolo();
//			BigliettiDAO.saveBigliettoSingolo(biglietto);
//		}
//		
//		for(int i = 0; i < 20; i++) {
//			Abbonamento abbonamento = new Abbonamento(TipologiaAbbonamento.SETTIMANALE);
//			BigliettiDAO.saveAbbonamento(abbonamento);
//		}
//		
//		for(int i = 0; i < 20; i++) {
//			Abbonamento abbonamento = new Abbonamento(TipologiaAbbonamento.MENSILE);
//			BigliettiDAO.saveAbbonamento(abbonamento);
//		}
//		
		/*Creo un nuovo rivenditore, con tutti i propri dati personali, compresi di p.IVA. Il rivenditore inizialmente non avrà biglietti da vendere.*/
		RivenditoriAutorizzati rivenditore1 = new RivenditoriAutorizzati("Sassari", "Via Giotto, 2", "Mario", "Rossi", "86334519757");

		/*Anzitutto salvo il rivenditore nel DB*/
//		DistribuzioneDAO.saveRivenditore(rivenditore1);

		/*Ecco la parte importante. Qua avviene la consegna dei biglietti al rivenditore indicato in ingresso nel metodo richiediBigliettiRivenditore();
		Il metodo funziona così: nella tabella Biglietti verranno riempiti i campi id_rivenditore con il rivenditore al quale saranno affidati i biglietti.
		I biglietti, per ogni chiamata del metodo, saranno 50 singoli, 5 mensili e 5 settimanali.*/
//		DistribuzioneDAO.richiediBigliettiRivenditore(1);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/*Qui trattiamo la vendita dei biglietti da parte dei rivenditori autorizzati. In sostanza gli eventuali clienti andranno in edicola ad acquistare i
		biglietti. Si potranno acquistare molteplici biglietti singoli o un solo abbonamento in quanto esso, essendo nominativo, dovrà essere univoco.
		Ciò ovviamente sarà possibile se il rivenditore avrà biglietti a disposizione. Prima di concedere l'acquisto di un abbonamento ,il rivenditore
		dovrà fare un check. Se l'utente possiede la tessera (non scaduta) potrà acquistare l'abbonamento.*/

		/*Con il metodo venditaBigliettiSingoliRivenditore verranno accettati in ingresso: il rivenditore, l'utente e il numero di biglietti che si vorranno
		acquistare. All'interno della tabella Biglietti, i biglietti singoli acquistati non avranno più un collegamento con il rivenditore ma solo
		ed esclusivamente con l'utente.*/
//		DistribuzioneDAO.venditaBigliettiSingoliRivenditore(1, 1, 2);
		
		/*Con i metodi venditaAbbonamentiRivenditore verranno accettati in ingresso il rivenditore e l'utente. All'interno della tabella Biglietti,
		l'abbonamento acquistato non avrà più un collegamento con il rivenditore ma solo con l'utente. All'interno dei metodi inoltre viene effettuato
		il check della tessera dell'utente.*/
		/*IMPORTANTE VALIDO SIA PER RIVENDITORI CHE PER DISTRIBUTORI AUTOMATICI: quando un utente con già un abbonamento acquistato vorrà acquistarne uno nuovo
		potrà tranquillamente farlo; tuttavia il precedente abbonamento verrà annullato e cancellato definitivamente dai Biglietti.*/
//		DistribuzioneDAO.venditaAbbonamentiSettimanaliRivenditore(1, 1);

		/*Ogni qualvolta un distributore venderà un biglietto, all'interno della tabella BigliettiEmessi verranno contati i biglietti venduti, il distributore
		relativo e la data di vendita.*/
		
		/*Con il metodo UtenteDAO.verificaAbbonamentodaTessera() accetto in ingresso il numero della tessera e verifico che l'abbonamento dell'utente, se presente,
		sia ancora valido o meno. Il metodo restituirà "No entity found for query" nel caso in cui non esista la tessera o l'utente non possieda un abbonamento. */
//		UtenteDAO.verificaAbbonamentodaTessera(1);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/*Creo l'istanza locale del distributore automatico da inserire poi nel DB.*/
		DistributoriAutomatici distributoreAutomatico1 = new DistributoriAutomatici("Ittiri", "Via dei Boschi, 6");
		
		/*Salvo il distributore automatico nel database*/
//		DistribuzioneDAO.saveDistributoreAutomatico(distributoreAutomatico1);
		
		/*I controlli della vendita dei biglietti sono simili a quelli del rivenditore, con in più un controllo sull'essere fuori servizio o meno.
		Ciò che cambia veramente è l'idea alla base. Il distributore non riceve in consegna i biglietti come il rivenditore, bensì esso possiede 
		un rullino di carta che stamperà singolarmente il biglietto o l'abbonamento quando esso verrà richiesto e lo genererà direttamente nel database 
		come nuovo Biglietto con l'utente già riferito. */
//		DistribuzioneDAO.venditaBigliettiSingoliDistributoreAutomatico(2, 3, 2);
//		DistribuzioneDAO.venditaAbbonamentoMensileDistributoreAutomatico(2, 3);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/*L'idea è quella di creare tratte e mezzi di trasporto. Le tratte possono essere percorse da più mezzi e avranno al loro interno un punto di partenza
		, un capolinea e un tempo medio di percorrenza. Questo tempo medio verrà calcolato ed aggiornato ogni qualvolta un mezzo percorre la tratta in questione.
		, calcolandone una media. I mezzi di trasporto invece possono essere tram o autobus. Ciascuno di essi possiede una determinata capienza e una 
		specifica tratta da percorrere. Inoltre, quando l'oggetto viene creato, il mezzo risulta essere in servizio e pertanto potrà iniziare a viaggiare.*/
		
		/*Creo le istanze locali delle tratte da percorrere.*/
		Tratta tratta1 = new Tratta("Ittiri", "Sassari");
		Tratta tratta2 = new Tratta("Sassari", "Ittiri");
		Tratta tratta3 = new Tratta("Via Roma", "Via Milano");
		Tratta tratta4 = new Tratta("Via Milano", "Via Roma");
		
		/*Creo le istanze locali dei mezzi di trasporto.*/
		Tram tram1 = new Tram(25, tratta3);
		Tram tram2 = new Tram(25, tratta4);	
		Autobus autobus1 = new Autobus(50, tratta1);
		Autobus autobus2 = new Autobus(50, tratta2);
		
		/*Salvo nel database le tratte e i mezzi. LE TRATTE DEVONO ESSERE SALVATE OBBLIGATORIAMENTE PRIMA DEI MEZZI.*/
//		TrasportiDAO.saveTratta(tratta1);
//		TrasportiDAO.saveTratta(tratta2);
//		TrasportiDAO.saveTratta(tratta3);
//		TrasportiDAO.saveTratta(tratta4);	
//		TrasportiDAO.saveMezzo(tram1);
//		TrasportiDAO.saveMezzo(tram2);
//		TrasportiDAO.saveMezzo(autobus1);
//		TrasportiDAO.saveMezzo(autobus2);
		
		
		/*Con il metodo TrasportiDAO.obliteraBigliettoSingolo accetto in ingresso un mezzo di trasporto e l'id dell'Utente. Tale id mi permetterà di accedere
		alla tabella Biglietti e di obliterare esclusivamente uno dei biglietti singoli posseduti dall'utente in questione. Una volta che il biglietto verrà
		obliterato esso sarà cancellato definitivamente dalla tabella Biglietti. Se la query non riporterà alcun risultato vorrà dire che l'utente in
		ingresso non possiede alcun biglietto e pertanto non potrà viaggiare.*/
//		TrasportiDAO.obliteraBigliettoSingolo(1, 1);
		
		/*Con il metodo TrasportiDAO.obliteraAbbonamento accetto in ingresso un mezzo di trasporto e l'id dell'Utente. Tale id mi permetterà di poter controllare
		se nella tabella Biglietti è presente un abbonamento relazionato all'utente in questione. Se così fosse l'utente potrà obliterare l'abbonamento nel 
		mezzo. Se l'abbonamento non risulta essere attivo, verrà attivato e sarà settata una data di attivazione e scadenza. Se invece l'abbonamento dovesse
		già essere attivo allora il sistema verificherà che esso non sia scaduto. Se fosse scaduto il cliente non potrà usufruire del mezzo.*/
//		TrasportiDAO.obliteraAbbonamento(1, 3);
//		UtenteDAO.verificaAbbonamentodaTessera(2);
		
		/*Con il metodo TrasportiDAO.cambiaStatoMezzo si può cambiare lo stato del mezzo da servizio a manutenzione o viceversa. Verranno così settate le date
		relative all'inizio della manutenzione (o servizio) e alla fine dello stato precedentemente assegnato, così da poter controllare accuratamente il tutto.*/
//		TrasportiDAO.cambiaStatoMezzo(3);

		/*Obliterando un biglietto in un mezzo in fase di manutenzione si riceverà un errore.*/
//		TrasportiDAO.obliteraAbbonamento(3, 3);
		
		/*Con il metodo TrasportiDAO.percorriTratta abbiamo la possibilità di percorrere effettivamente la tratta impostata nel mezzo. Il metodo accetta due 
		parametri in ingresso. Il primo è l'id del mezzo che dovrà viaggiare e il secondo invece riguarda i minuti della durata del percorso.
		All'interno del metodo mi assicuro prima di tutto che il mezzo sia in stato di servizio. Se così fosse allora si potrà percorrere correttamente la
		tratta assegnata. La tappa appena percorsa andrà a memorizzarsi all'interno della tabella TappePercorse con relativo id del mezzo.
		Dinamicamente inoltre si andrà ad aggiornare il tempo medio di percorrenza di una determinata tratta nella tabella Tratta semplicemente ricavando tutte
		le tappe percorse in una determinata tratta, sommandole e dividendole per il loro numero. */
//		TrasportiDAO.percorriTratta(1, 25);
//		TrasportiDAO.percorriTratta(1, 27);
//		TrasportiDAO.percorriTratta(1, 18);
//		TrasportiDAO.percorriTratta(1, 22);
//		TrasportiDAO.percorriTratta(2, 22);
	}

}
