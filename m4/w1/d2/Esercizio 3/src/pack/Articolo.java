package pack;

public class Articolo {

	int codiceArticolo;
	String descrizioneArticolo;
	double prezzo;
	int numeroPezzi;
	static int count = 0;
	
	public Articolo(String descrizioneArticolo, double prezzo) {
		count++;
		this.codiceArticolo = count;
		this.descrizioneArticolo = descrizioneArticolo;
		this.prezzo = prezzo;
		this.numeroPezzi = 30;
	}
	
	public void stampaArticolo() {
		System.out.println("Codice: " + this.codiceArticolo + ", Descrizione: " + this.descrizioneArticolo + ", Prezzo: " + this.prezzo + ", Pezzi: " + this.numeroPezzi );
	}
}
