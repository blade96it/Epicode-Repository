package pack1;

public class Audio extends ElementoMultimediale implements Volume {

	private int volume;
	private int durata;
	
	public Audio(String titolo, int durata) {
		
		super(titolo);
		this.volume = 5;
		this.durata = durata;
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
		for(int j = 0; j < this.volume; j++) {
			puntiEsclamativi+= "!"; 
		}
		for(int i = 0; i < this.durata; i++) {
			System.out.println(this.titolo + puntiEsclamativi);
		}

	}

	@Override
	public void stampa(int scelta) {
		
		System.out.println(scelta + ". Audio: " + this.titolo + " / Durata: " + this.durata + " minuti");
	}

}
