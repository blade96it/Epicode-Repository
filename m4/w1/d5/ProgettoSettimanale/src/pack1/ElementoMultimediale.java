package pack1;

public abstract class ElementoMultimediale {
	
	protected String titolo;
	
	public ElementoMultimediale(String titolo) {
		this.titolo = titolo;
	}
	
	public abstract void stampa(int stampa);
}
