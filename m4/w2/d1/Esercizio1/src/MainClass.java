import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		int [] array = new int [5];
		Scanner scannerScelta = new Scanner(System.in);
		Scanner scannerNumero = new Scanner(System.in);
		for(int i = 0; i < array.length; i++) {
			array[i] = (int)Math.floor(Math.random() * (10 - 1 + 1) + 1);
			System.out.print(array[i]);
		}
		System.out.println("");
		
		int scelta = 10;
		int numero;
		while(scelta != 0) {
			System.out.println("Inserisci il numero della posizione, da 1 a 5, nel quale vuoi inserire un nuovo numero nell'array. Premi 0 per chiudere il programma.");
			scelta = scannerScelta.nextInt();
			if(scelta == 0) {
				System.out.println("Chiusura del programma...");
				break;
			}
			System.out.println("Perfetto! Ora inserisci il numero che vuoi immmettere");
			numero = scannerNumero.nextInt();
			try {
			array[scelta-1] = numero;
			stampaArray(array);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("La posizione da te inserita non è valida!");
			}
		}
		
	}
	
	public static void stampaArray(int [] array) {		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println("");
	}

}
