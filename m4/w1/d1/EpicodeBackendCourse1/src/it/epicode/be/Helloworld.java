package it.epicode.be;

import java.util.Arrays;
import java.util.Scanner;

public class Helloworld {

public static void main (String[] args)
		{
		// Esercizio #1 - stampo in console la frase seguente
		
		System.out.println("This is my first Epicode Java Project!");
		
		//Esercizio #2 - chiamo i metodi e li stampo in console

		int numero1 = 2;
		int numero2 = 3;
		String stringa = "Banana";
		String array [] = {"Elemento1", "Elemento2", "Elemento3", "Elemento4", "Elemento5"};
		System.out.println("Il risultato della moltiplicazione tra " + numero1 + " e " + numero2 + " è: "+moltiplica(numero1, numero2));
		System.out.println(concatena(stringa, numero1));
		System.out.println(Arrays.toString(inserisciInArray(array, stringa)));
		
		//Esercizio #3 - scanner con concatenazione stringhe
		
		System.out.println("Inserisci la prima stringa...");
		Scanner stringScanner = new Scanner(System.in);
		String stringa1 = stringScanner.nextLine();
		System.out.println("Inserisci la seconda stringa...");
		String stringa2 = stringScanner.nextLine();
		System.out.println("Inserisci la terza stringa...");
		String stringa3 = stringScanner.nextLine();
		String ordineCorretto = stringa1 + stringa2+ stringa3;
		String ordineInverso = stringa3 + stringa2+ stringa1;
		System.out.println("Concateno le stringhe in ingresso in ordine di inserimento... " + ordineCorretto);
		System.out.println("Concateno le stringhe in ingresso in ordine di inserimento... " + ordineInverso);
		
		//Esercizio #4 - chiamo i metodi e li stampo in console
		
		double lato1 = 5.6;
		double lato2 = 8.3;
		System.out.println("Il perimetro del rettangolo è pari a: " + perimetroRettangolo(lato1, lato2));
		int numero = 3;
		System.out.println(pariDispari(numero));
		System.out.println("L'area del triangolo è pari a: " + areaTriangolo(lato1, lato2));
		}


public static int moltiplica(int a, int b) {
	return a * b;
}

public static String concatena(String a, int b) {
	return a + b;
}

public static String [] inserisciInArray(String [] array, String b ) {
	int lunghezza = array.length;
	String array2 [] = new String [lunghezza+1];
	int i = 0;
	int j = 0;
	while(i < array2.length) {
		if(i == 2) {
			array2[i] = b;
			i++;
		}
		else {
			array2[i] = array[j];
			i++;
			j++;
		}
	}
	return array2;
}
public static int perimetroRettangolo(double lato1, double lato2) {
	int perimetro = (int) ((int) 2 * (lato1 + lato2));
	return perimetro;
}

public static int pariDispari(int numero) {
	if((numero % 2) == 0) {
		return 0;
	}
	else {
		return 1;
	}
}

public static int areaTriangolo(double lato1, double lato2) {
	int area = (int) ((lato1 * lato2) / 2);
	return area;
}
}