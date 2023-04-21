package config_bean_configuration;

import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ordine {

	private int numeroOrdine;
	private List<Prodotto> listaProdotti;
	private StatoOrdine stato;
	private int numeroCoperti;
	private LocalTime oraOrdine;
	private double totaleOrdine;
	private Tavolo tavolo;
	
	public Ordine(int numeroOrdine, List<Prodotto> listaProdotti, int numeroCoperti, Tavolo tavolo) {
		this.numeroOrdine = numeroOrdine;
		this.listaProdotti = listaProdotti;
		this.numeroCoperti = numeroCoperti;
		this.stato = StatoOrdine.IN_CORSO;
		this.oraOrdine = LocalTime.now();
		this.totaleOrdine = calcolaTotale();
		this.tavolo = tavolo;
	}
	
	public double calcolaTotale() {
		double totale = 0;
		for(Prodotto prodotto : this.listaProdotti) {
			totale += prodotto.getPrezzo();
		}
		return totale;
	}
	
	public void stampaOrdine() {
		System.out.println("Ordine n°: " + this.numeroOrdine + " - Numero Coperti: "
	+ this.numeroCoperti + " - Stato: " + this.stato + " - Tavolo n°: " + this.tavolo.getNumeroTavolo() + " - Totale Ordine: " + this.totaleOrdine + "$");
	}
}
