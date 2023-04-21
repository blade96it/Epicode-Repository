package pack1;

public class Video extends ElementoMultimediale implements Volume, Luminosità {

	private int volume;
	private int luminosità;
	private int durata;
	
	public Video(String titolo, int durata) {
		
		super(titolo);
		this.volume = 5;
		this.luminosità = 5;
		this.durata = durata;
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

	@Override
    public void abbassaVolume() {
		
		if(this.volume > 0) {                //mi assicuro che il volume non possa scendere sotto lo 0
			this.volume--;
		}
		else {
			System.out.println("Il volume è già al minimo!");
		}

	}

	@Override
	public void alzaVolume() {
		
		if(this.volume < 10) {          //mi assicuro che il volume non superi la soglia massima di 10
			this.volume++;
		}
		else {
			System.out.println("Il volume è già al massimo!");
		}

	}

	public void play() {
		
		String puntiEsclamativi = "";              //avvio una stringa che ciclerà in modo tale che essa aggiunga tanti punti esclamativi quanto la durata presente.
		for(int j = 0; j < this.volume; j++) {     //stessa cosa per gli asterischi con la luminosità
			puntiEsclamativi+= "!"; 
		}
		String asterischi = "";
		for(int k = 0; k < this.luminosità; k++) {
			asterischi+= "*";
		}
		for(int i = 0; i < this.durata; i++) {
			System.out.println(this.titolo + puntiEsclamativi + asterischi);
		}
		
	}
	
	@Override
	public void stampa(int scelta) {
		
		System.out.println(scelta + ". Video: " + this.titolo + " / Durata: " + this.durata + " minuti");
	}

}
