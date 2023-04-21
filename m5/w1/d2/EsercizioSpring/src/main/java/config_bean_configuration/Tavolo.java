package config_bean_configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tavolo {

	private int numeroTavolo;
	private int numeroMaxCoperti;
	private StatoTavolo stato;
	private Ordine ordine;
	
	public Tavolo(int numeroTavolo, int numeroMaxCoperti) {
		this.numeroTavolo = numeroTavolo;
		this.numeroMaxCoperti = numeroMaxCoperti;
		this.stato = StatoTavolo.LIBERO;
	}
	
	public void stampaTavolo() {
		System.out.println("Tavolo n°: " + this.numeroTavolo + " - Numero Coperti Massimo: " 
	+ this.numeroMaxCoperti + " - Stato: " + this.stato + " - Ordine n°: " + this.ordine);
	}
}
