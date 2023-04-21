package pack1;

public class GestioneDipendenti {

	public static void main(String[] args) {

		Dipendente dipendente1 = new Dipendente(1, Dipartimento.PRODUZIONE);
		Dipendente dipendente2 = new Dipendente(2, Dipartimento.PRODUZIONE);
		Dipendente dipendente3 = new Dipendente(3, 1200, 40, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE);
		Dipendente dipendente4 = new Dipendente(4, 2000, 50, Livello.DIRIGENTE, Dipartimento.VENDITE);
		
		dipendente1.promuovi();
		dipendente3.promuovi();
		
		dipendente1.stampaDatiDipendente();
		dipendente2.stampaDatiDipendente();
		dipendente3.stampaDatiDipendente();
		dipendente4.stampaDatiDipendente();
		
		double somma = 0;
		Dipendente [] arrayDipendenti = {dipendente1, dipendente2, dipendente3, dipendente4};
		for(int i = 0; i < arrayDipendenti.length; i++) {
			somma+= arrayDipendenti[i].getStipendio() + (arrayDipendenti[i].getImportoOrarioStraordinario() * 5);
		}
		
		System.out.println("La somma di tutti gli stipendi, compresi gli straordinari, è pari a: " + somma);
	}

}
