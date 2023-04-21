package pack3;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);   //inizializzo lo scanner
		String stringa;
		String newString ="";                       //istanzio una stringa che conterrà la parola divisa da virgole
		do {
			System.out.println("Inserisci una parola e verrà divisa in virgole. Digita ':q' per uscire dal programmma");
			stringa = scanner.nextLine();
			char [] separatore = stringa.toCharArray();            //divido la stringa in ingresso in un array di char diviso in caratteri
			if(!stringa.equals(":q")) {                            //se la stringa in ingresso è diversa da :q esegui quanto sotto
			for(int i = 0; i < separatore.length; i++) {           //in questo ciclo for faccio ciclare l'array di char e assegno i caratteri separati da una virgola--
				if(i != separatore.length -1) {					   //-- nella stringa newString. Quando l'array arriverà alla sua ultima posizione mi assicuro che--
				newString+= separatore[i] + ",";                   //--non venga inserita una virgola dopo l'ultima lettera
				}
				else { 
					newString+= separatore[i];
				}
			}
			System.out.println(newString);
			newString = "";
			}
		} while(!stringa.equals(":q"));                   //il ciclo si concluderà quando l'utente inserirà :q
	}

}
