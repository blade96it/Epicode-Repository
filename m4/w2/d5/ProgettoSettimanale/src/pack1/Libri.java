package pack1;

public class Libri extends CatalogoBibliotecario{

	private String autore;
	private String genere;
	
	public Libri(long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	@Override
	public long getCodiceISBN() {
		// TODO Auto-generated method stub
		return super.getCodiceISBN();
	}

	@Override
	public String getTitolo() {
		// TODO Auto-generated method stub
		return super.getTitolo();
	}

	@Override
	public int getAnnoPubblicazione() {
		// TODO Auto-generated method stub
		return super.getAnnoPubblicazione();
	}

	@Override
	public int getNumeroPagine() {
		// TODO Auto-generated method stub
		return super.getNumeroPagine();
	}

	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}

	@Override
	public void stampa() {
		System.out.println("Titolo: " + getTitolo() + " - Anno Pubblicazione: " + getAnnoPubblicazione() + " - Numero Pagine: " + getNumeroPagine() + " - Codice ISBN: " + getCodiceISBN() + " - Autore: " + this.autore);
	}
}
