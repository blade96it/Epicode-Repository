package pack1;

public class Immagine extends ElementoMultimediale implements Luminosità {

	private int luminosità;
	
	public Immagine(String titolo) {
		
		super(titolo);
		this.luminosità = 5;
	}

	@Override
	public void aumentaLuminosità() {
		
		if(this.luminosità < 10) {          //mi assicuro che la luminosità non superi la soglia massima di 10
			this.luminosità++;
		}
		else {
			System.out.println("La luminosità è già al massimo!");
		}
	}

	@Override
	public void diminuisciLuminosità() {
		
		if(this.luminosità > 0) {                //mi assicuro che la luminosità non possa scendere sotto lo 0
			this.luminosità--;
		}
		else {
			System.out.println("La luminosità è già al minimo!");
		}
	}
	
	public void show() {
		
		String asterischi = "";            //avvio una stringa che ciclerà in modo tale che essa aggiunga tanti asterischi quanto la luminosità presente.
		for(int k = 0; k < this.luminosità; k++) {
			asterischi+= "*";
		}
		System.out.println(this.titolo + asterischi);
		
	}
	
	@Override
	public void stampa(int scelta) {
		
		System.out.println(scelta + ". Audio: " + this.titolo);
	}

}
