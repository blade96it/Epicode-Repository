package pack;

public class Carrello {

	Cliente cliente;
	Articolo [] arrArticoli;
	double totale;
	
	public Carrello(Cliente cliente, Articolo [] arrArticoli) {
		this.cliente = cliente;
		this.arrArticoli = arrArticoli;
		this.totale = 0;
	}
	
	public double calcoloTotale() {
		for(int i = 0; i < this.arrArticoli.length; i++) {
			this.totale+= this.arrArticoli[i].prezzo;
		}
		return this.totale;
	}
}
