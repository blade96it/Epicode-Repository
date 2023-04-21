package pack1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

	static List<Utente> listaUtenti= new ArrayList<Utente>();
	
	public static void main(String[] args) {
		
		try {
			DbConnection db = new DbConnection();
			db.creaTabUtenti();
			
			Utente u = new Utente(0, "Mario", "Rossi", "1/8/1999", 23, "m.rossi@example.com");
			Utente u2 = new Utente(0, "Giuseppe", "Verdi", "15/3/2003", 20, "g.verdi@example.com");
			//db.salvaUtente(u2);
			
			listaUtenti = db.leggiUtenti();
			
			Utente ut = listaUtenti.get(0);
			ut.email = "mario.rossi@example.com";
			db.modificaUtente(ut);
			
			for(Utente utente : listaUtenti) {
				System.out.println(utente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
