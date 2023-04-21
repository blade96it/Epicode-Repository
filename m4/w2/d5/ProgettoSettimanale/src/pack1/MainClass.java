package pack1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

public class MainClass {

	public static void main(String[] args) throws IOException {
		
		//definisco il catalogo come lista dove andremo ad inserire, tramite apposito metodo, tutti i vari elementi
		List<CatalogoBibliotecario> catalogo = new ArrayList<CatalogoBibliotecario>();
		File file = new File("dirfiles/archivio.txt");
		
		//istanzio 5 libri e 5 riviste
		CatalogoBibliotecario libro1 = new Libri(1, "Il Signore degli Anelli", 1954, 1296, "John R.R. Tolkien", "Fantasy");
		CatalogoBibliotecario libro2 = new Libri(2, "Una Tempesta di Spade", 2000, 1224, "George R.R. Martin", "Fantasy");
		CatalogoBibliotecario libro3 = new Libri(3, "Shining", 1977, 592, "Stephen King", "Thriller");
		CatalogoBibliotecario libro4 = new Libri(4, "Origin", 2017, 560, "Dan Brown", "Thriller");
		CatalogoBibliotecario libro5 = new Libri(5, "It", 1986, 1216, "Stephen King", "Horror");
		
		CatalogoBibliotecario rivista1 = new Riviste(6,"Focus", 2023, 124, Periodicità.MENSILE);
		CatalogoBibliotecario rivista2 = new Riviste(7,"La Settimana Enigmistica", 2023, 54, Periodicità.SETTIMANALE);
		CatalogoBibliotecario rivista3 = new Riviste(8,"Ciak Magazine", 2023, 78, Periodicità.MENSILE);
		CatalogoBibliotecario rivista4 = new Riviste(9,"Giallo Zafferano", 2023, 89, Periodicità.SETTIMANALE);
		CatalogoBibliotecario rivista5 = new Riviste(10,"Antropologia", 2022, 203, Periodicità.SEMESTRALE);
		
		//utilizzo il metodo aggiungiElemento per poter aggiungere o un libro o una rivista all'interno del catalogo.
		aggiungiElemento(libro1,catalogo);
		aggiungiElemento(libro2,catalogo);
		aggiungiElemento(libro3,catalogo);
		aggiungiElemento(libro4,catalogo);
		aggiungiElemento(libro5,catalogo);
		aggiungiElemento(rivista1,catalogo);
		aggiungiElemento(rivista2,catalogo);
		aggiungiElemento(rivista3,catalogo);
		aggiungiElemento(rivista4,catalogo);
		aggiungiElemento(rivista5,catalogo);
		
		//catalogo.forEach(elemento -> System.out.println(elemento.getTitolo()));
		
		//assegno al catalogo il risultato del metodo che rimuoverà un elemento al suo interno attraverso l'ISBN
		//catalogo = rimuoviElemento(catalogo, 2);
		
		filtraPerISBN(catalogo, 10);
		filtraPerAnno(catalogo, 1954);
		filtraPerAutore(catalogo, "Stephen King");
		
		scriviSuFile(file, catalogo);
		
	}

	//con questo metodo accetto in ingresso un libro o una rivista e il catalogo come lista che si aggiornerà restituendo l'elemento da aggiungere.
	public static List<CatalogoBibliotecario> aggiungiElemento(CatalogoBibliotecario aggiunta, List<CatalogoBibliotecario> catalogo) {
		catalogo.add(aggiunta);
		return catalogo;
	}
	
	//con questo metodo accetto in ingresso il catalogo e il codice ISBN e filtro la lista affinchè vengano rimossi gli elementi con l'ISBN definito.
	public static List<CatalogoBibliotecario> rimuoviElemento(List<CatalogoBibliotecario> catalogo, long isbn) {
		catalogo = catalogo.stream().filter(elemento -> elemento.getCodiceISBN() != isbn).collect(Collectors.toList());
		return catalogo;
	}
	
	//con questo metodo accetto in ingresso il catalogo e il codice ISBN e filtro una nuova lista provvisoria cosicchè stampi unicamente gli elementi interessati.
	public static void filtraPerISBN(List<CatalogoBibliotecario> catalogo, long isbn) {
		List<CatalogoBibliotecario> lista = catalogo.stream().filter(elemento -> elemento.getCodiceISBN() == isbn).collect(Collectors.toList());
		if(!lista.isEmpty()) {
			lista.forEach(elemento -> elemento.stampa());
		}
		else {
			System.out.println("Non esiste nè libro nè rivista con tale ISBN sul nostro archivio!");
		}
	}
	
	//con questo metodo accetto in ingresso il catalogo e il codice ISBN e filtro una nuova lista provvisoria cosicchè stampi unicamente gli elementi interessati.
		public static void filtraPerAnno(List<CatalogoBibliotecario> catalogo, int anno) {
			List<CatalogoBibliotecario> lista = catalogo.stream().filter(elemento -> elemento.getAnnoPubblicazione() == anno).collect(Collectors.toList());
			if(!lista.isEmpty()) {
				lista.forEach(elemento -> elemento.stampa());
			}
			else {
				System.out.println("Non esiste nè libro nè rivista con tale anno sul nostro archivio!");
			}
		}
		
		//con questo metodo accetto in ingresso il catalogo e l'autore.
		public static void filtraPerAutore(List<CatalogoBibliotecario> catalogo, String autore) {
			List<Libri> listaLibri = new ArrayList<Libri>(); //istanzio una lista di Libri
			for(CatalogoBibliotecario elemento: catalogo) {  //mi assicuro che ogni elemento ciclato sia di tipo Libri così da poter riempire poi la relativa lista
				if(elemento instanceof Libri) {
					listaLibri.add((Libri) elemento);
				}
			}		
			//uso il solito filter per poter comparare tutti gli elementi libri
			listaLibri = listaLibri.stream().filter(elemento -> elemento.getAutore() == autore).collect(Collectors.toList());
			if(!listaLibri.isEmpty()) {
				listaLibri.forEach(elemento -> elemento.stampa());
			}
			else {
				System.out.println("Non esiste libro con tale autore sul nostro archivio!");
			}
		}
		
		public static void scriviSuFile(File file, List<CatalogoBibliotecario> catalogo) throws IOException {
			StringBuilder string = new StringBuilder();
			for(CatalogoBibliotecario elemento: catalogo) {
				string.append(elemento.getTitolo() + ", " + elemento.getAnnoPubblicazione() + ", " + elemento.getNumeroPagine());
			}
			
			FileUtils.writeStringToFile(file, string.toString(), "UTF-8");
		}
}
