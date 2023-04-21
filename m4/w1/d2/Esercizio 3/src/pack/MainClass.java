package pack;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Articolo articolo1 = new Articolo("Un bell'articolo", 23.32);
		Articolo articolo2 = new Articolo("Un bell'articolo", 24.32);
		Articolo articolo3 = new Articolo("Un bell'articolo", 25.32);
		Articolo articolo4 = new Articolo("Un bell'articolo", 26.32);
		Articolo articolo5 = new Articolo("Un bell'articolo", 27.32);
		
		Cliente cliente1 = new Cliente("Manuel Gadau", "gadaumanuel@gmail.com", "12/02/2013");
		Cliente cliente2 = new Cliente("Peppino Gadau", "gadaumanuel@gmail.com", "12/02/2014");
		Cliente cliente3 = new Cliente("Enzo Gadau", "gadaumanuel@gmail.com", "12/02/2015");
		Cliente cliente4 = new Cliente("Martire Gadau", "gadaumanuel@gmail.com", "12/02/2016");
		Cliente cliente5 = new Cliente("Lord Gadau", "gadaumanuel@gmail.com", "12/02/2017");
		
		Articolo[] arrayDiArticoli = {articolo1, articolo4, articolo2};
		
		Carrello carrello1 = new Carrello(cliente2, arrayDiArticoli);
		
		System.out.println("Il totale del carrello del cliente: " + carrello1.cliente.nomeCognome + " è di: " + carrello1.calcoloTotale() + "€");
	}

}
