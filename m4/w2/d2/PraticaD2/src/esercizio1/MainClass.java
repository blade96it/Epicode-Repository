package esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainClass {

	public static void main(String[] args) {

		Set<String> elencoParole = new HashSet<String>();
		Set<String> elencoParoleDuplicate = new HashSet<String>();
		
		Scanner scanner = new Scanner(System.in);
		Scanner scannerParola = new Scanner(System.in);
		System.out.println("Ciao! Quante parole vuoi inserire nell'elenco?");
		int numero = scanner.nextInt();
		
		String parola = "";
		for(int i = 0; i < numero; i++) {
			if(i > 0) {
				System.out.println("Scrivi la parola da inserire...");
				parola = scannerParola.nextLine();
			}
			if(elencoParole.contains(parola)) {
				elencoParoleDuplicate.add(parola);
			}
			if(i == 0) {
				System.out.println("Scrivi la parola da inserire...");
				parola = scannerParola.nextLine();
			}
			elencoParole.add(parola);
		}
		
		System.out.println("Ecco l'elenco delle parole duplicate: " + elencoParoleDuplicate);
		System.out.println("Il numero delle parole distinte è pari a: " + elencoParole.size());
		System.out.println("Ecco l'elenco delle parole distinte: " + elencoParole);
		
	}

}
