package pack;

public class SimCard {
	
	String numeroTelefonico;
	int credito;
	String [] listaChiamate;
	int numeroChiamate;
	
	public SimCard (String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
		this.credito = 0;
		this.listaChiamate = new String[5];
		this.numeroChiamate = 0;
	}
	
	public void stampaSim() {
		System.out.println("Ecco i dati della tua SIM - Numero di telefono: " + this.numeroTelefonico + ", Credito Disponibile: " + this.credito);
		if(this.numeroChiamate > 0) {
			System.out.println("Ecco la lista delle tue ultime 5 chiamate:");
			for(int i = 0; i < this.numeroChiamate; i++) {
				System.out.println(this.listaChiamate[i]);
			}
		}
		else {
			System.out.println("Non hai effettuato alcuna chiamata!");
		}
	}
	
	public void chiama(String numeroChiamato, String minutiChiamata) {
		if(this.credito == 0) {
			System.out.println("Non hai creduto sufficiente, ricarica!");
		}
		else {
			this.listaChiamate[this.numeroChiamate] = "Numero: " + numeroChiamato + ", Durata chiamata: " + minutiChiamata;
			this.numeroChiamate++;
			this.credito--;
		}
		
	}
	
	public void ricarica(int a) {
		this.credito+= a;
	}
}
