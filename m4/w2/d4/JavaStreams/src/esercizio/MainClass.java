package esercizio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {

	public static void main(String[] args) {
		
		Product prodotto1 = new Product(1, "Sapone", "Baby", 50.5);
		Product prodotto2 = new Product(1, "Maglietta", "Boys", 35.3);
		Product prodotto3 = new Product(1, "Maglione", "Boys", 49.5);
		Product prodotto4 = new Product(1, "Libro1", "Books", 10.5);
		Product prodotto5 = new Product(1, "Libro2", "Books", 40.1);
		Product prodotto6 = new Product(1, "Libro3", "Books", 125.6);
		Product prodotto7 = new Product(1, "Culla", "Baby", 139.5);
		Product prodotto8 = new Product(1, "Biberon", "Baby", 219.5);
		Product prodotto9 = new Product(1, "Camicia", "Boys", 12.0);
		Product prodotto10 = new Product(1, "Pantaloni", "Boys", 99.99);
		List<Product> listaProdotti = new ArrayList<>();
		listaProdotti.add(prodotto1);
		listaProdotti.add(prodotto2);
		listaProdotti.add(prodotto3);
		listaProdotti.add(prodotto4);
		listaProdotti.add(prodotto5);
		listaProdotti.add(prodotto6);
		listaProdotti.add(prodotto7);
		listaProdotti.add(prodotto8);
		listaProdotti.add(prodotto9);
		listaProdotti.add(prodotto10);
		
		Customer customer1 = new Customer(1, "Manuel", 2);
		Customer customer2 = new Customer(2, "Gino", 2);
		Customer customer3 = new Customer(3, "Carlo", 2);
		List<Customer> listaClienti = new ArrayList<>();
		listaClienti.add(customer1);
		listaClienti.add(customer2);
		listaClienti.add(customer3);
		
		Order ordine1 = new Order(1, "status", null, null, listaProdotti, customer3);
		Order ordine2 = new Order(1, "status", null, null, listaProdotti, customer3);
		Order ordine3 = new Order(1, "status", null, null, listaProdotti, customer3);
		List<Order> listaOrdini = new ArrayList<>();
		listaOrdini.add(ordine1);
		listaOrdini.add(ordine2);
		listaOrdini.add(ordine3);
		
		
		
		Stream<Product> prodottiBooks = listaProdotti.stream().filter(prodotto -> prodotto.getCategory() == "Books" && prodotto.getPrice() > 100);
		System.out.println("Ecco la lista dei prodotti appartenenti alla categoria Books e con un prezzo superiore a 100: ");
		prodottiBooks.forEach(prodotto -> System.out.println(prodotto.getName() + " - " + prodotto.getPrice()));
		
		List<Order> ordiniBaby = listaOrdini.stream()
			    .map(order -> {
			        List<Product> prodottiFiltrati = order.getProducts().stream()
			            .filter(product -> product.getPrice() > 10)
			            .collect(Collectors.toList());
			        return new Order(prodottiFiltrati);
			    })
			    .filter(order -> !order.getProducts().isEmpty())
			    .collect(Collectors.toList());
		ordiniBaby.forEach(ordine -> ordine.getProducts().forEach(prodotto -> System.out.println(prodotto.getName())));
	}
}
