package pack4;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci un numero e verrà avviato il conto alla rovescia");
		int numero = scanner.nextInt();
		System.out.println(numero);
		for(int i = 0; i < numero; i++) {
			System.out.println(numero-i);
		}
		System.out.println(0);
	}

}
