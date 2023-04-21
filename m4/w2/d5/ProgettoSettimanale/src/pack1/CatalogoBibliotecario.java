package pack1;

public abstract class CatalogoBibliotecario {

	private long codiceISBN;
	private String titolo;
	private int annoPubblicazione;
	private int numeroPagine;
	
	public CatalogoBibliotecario(long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public long getCodiceISBN() {
		return codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}
	
	public void stampa() {
		System.out.println("Titolo: " + this.titolo + " - Anno Pubblicazione: " + this.annoPubblicazione + " - Numero Pagine: " + this.numeroPagine + " - Codice ISBN: " + this.codiceISBN);
	}
	
}
