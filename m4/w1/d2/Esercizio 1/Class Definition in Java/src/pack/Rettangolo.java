package pack;

public class Rettangolo {
	
	int altezza;                                       //imposto le proprietà della classe
	int larghezza;
	
	public Rettangolo(int altezza, int larghezza) {    //definisco il costruttore della classe Rettangolo
		this.altezza = altezza;
		this.larghezza = larghezza;
	}
	
	public int calcoloPerimetro() {                    //metodo che restituisce il perimetro del rettangolo
		return (2*this.altezza) + (2*this.larghezza);
	}
	
	public int calcoloArea() {                         //metodo che restituisce l'area del rettangolo
		return this.altezza + this.larghezza;
	}
}
