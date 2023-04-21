package pack2;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci un numero...");
		int numero = scanner.nextInt();
		switch (numero) {
		case 0: {
			System.out.println("Zero");
			break;
		}
		case 1: {
			System.out.println("Uno");
			break;
		}
		case 2: {
			System.out.println("Due");
			break;
		}
		case 3: {
			System.out.println("Tre");
			break;
		}
		default:
			System.out.println("Il valore in ingresso non è compreso tra 0 e 3");
		}
	}

}
