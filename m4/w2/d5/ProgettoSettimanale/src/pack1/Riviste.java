package pack1;

public class Riviste extends CatalogoBibliotecario {

	private Periodicità periodicità;
	
	public Riviste(long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.periodicità = periodicità;
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

	public Periodicità getPeriodicità() {
		return periodicità;
	}
	
	@Override
	public void stampa() {
		// TODO Auto-generated method stub
		super.stampa();
	}

}
