package pack2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		final DecimalFormat formato = new DecimalFormat("0.0");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ciao! Quanti kilometri hai percorso nel tuo ultimo viaggio?");
		double km = scanner.nextDouble();
		System.out.println("Quanti litri di benzina hai rifornito?");
		double litri = scanner.nextDouble();
		try {
			check0(litri);
			double kmAlLitro = km / litri;
			System.out.println("La tua velocità media è stata probabilmente di: " + formato.format(kmAlLitro) + " km/l");
		}
		catch(Exception e) {
			System.out.println("Devi rifornire più di 0 litri per far viaggiare il tuo bolide!");
		}
	}

	public static void check0(double valore) throws Exception {
		if(valore == 0 ) {
			throw new Exception("errore");
		}
	}
}
