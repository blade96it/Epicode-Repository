package esercizio3;

import java.util.HashMap;
import java.util.Map.Entry;

public class MainClass {

	public static void main(String[] args) {
		
		HashMap<String, String> rubrica = new HashMap<String, String>();
		nuovoContatto(rubrica, "Manuel", "3385967332");
		nuovoContatto(rubrica, "Giuseppe", "3325566332");
		nuovoContatto(rubrica, "Sabrina", "3425565332");
		stampaRubrica(rubrica);
		rimuoviContatto(rubrica, "Giuseppe");
		stampaRubrica(rubrica);
		cercaContattoNumero(rubrica, "3385967332");
		cercaContattoNome(rubrica, "Manuel");
	}

	public static void nuovoContatto(HashMap<String, String> rubrica, String nome, String numero) {
		rubrica.put(nome, numero);
	} 
	
	public static void rimuoviContatto(HashMap<String, String> rubrica, String nome) {
		rubrica.remove(nome);
	}
	
	public static void cercaContattoNumero(HashMap<String, String> rubrica, String numero) {
		for(Entry<String, String> contatto: rubrica.entrySet()) {
			if(contatto.getValue() == numero) {
		        System.out.println("Il numero da te inserito appartiene a: " + contatto.getKey());
		        break;
		      }
		}
	}
	
	public static void cercaContattoNome(HashMap<String, String> rubrica, String nome) {
		System.out.println("Il nome da te inserito possiede questo numero telefonico: " + rubrica.get(nome));
	}
	
	public static void stampaRubrica(HashMap<String, String> rubrica) {
		System.out.println(rubrica);
	}
}
