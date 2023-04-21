package esercizio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		ArrayList<Integer> listaInteri = new ArrayList<Integer>();
		ArrayList<Integer> listaInversa = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ciao! Inserisci la lunghezza della tua lista");
		int lunghezza = scanner.nextInt();
		
		listaInteri = randomList(lunghezza);          //Funzione 1
		System.out.println(listaInteri);
		
		listaInversa = listaInversa(listaInteri);     //Funzione 2
		System.out.println(listaInversa);
		
		stampaPariDispari(listaInteri, false);        //Funzione 3
	}
	
	public static ArrayList<Integer> randomList (int numero) {        //funzione che ritorna un arraylist con numeri casuali da 0 a 100.
		ArrayList<Integer> lista = new ArrayList<Integer>();
		for(int i = 0; i < numero; i++) {
			lista.add((int)Math.floor(Math.random() * (100 - 0 + 1) + 0));
		}
		return lista;
	}
	
	public static ArrayList<Integer> listaInversa (ArrayList<Integer> listaInteri) {  //funzione che ritorna un arraylist uguale al primo più l'ordine inverso degli elementi.
		ArrayList<Integer> listaFinale = new ArrayList<Integer>();
		listaFinale.addAll(listaInteri);
		Collections.reverse(listaInteri);
		listaFinale.addAll(listaInteri);
		return listaFinale;
	}

	public static void stampaPariDispari (ArrayList<Integer> lista, boolean bool) {  //funzione che stampa i numeri di un arraylist in ingresso in posizione pari o dispari.
		if(bool) {
			System.out.println("Numeri in posizione pari: ");
			for(int i = 0; i < lista.size(); i++) {
				if(i % 2 == 0) {
					System.out.print(lista.get(i) + ", ");
				}
			}
		}
		else {
			System.out.println("Numeri in posizione dispari: ");
			for(int i = 0; i < lista.size(); i++) {
				if(i % 2 != 0) {
					System.out.print(lista.get(i) + ", ");
				}
			}
		}
	}
}
