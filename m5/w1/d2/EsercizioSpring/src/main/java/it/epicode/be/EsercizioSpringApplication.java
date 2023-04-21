package it.epicode.be;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config_bean_configuration.ConfigurationGestioneOrdini;
import config_bean_configuration.ConfigurationProdotto;
import config_bean_configuration.Drinks;
import config_bean_configuration.Franchise;
import config_bean_configuration.Ordine;
import config_bean_configuration.Pizzas;
import config_bean_configuration.Prodotto;
import config_bean_configuration.Tavolo;
import config_bean_configuration.Toppings;

@SpringBootApplication
public class EsercizioSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsercizioSpringApplication.class, args);
		System.out.println();
		System.out.println("PIZZAS");
		System.out.println();
		List<Pizzas> listaPizzas = new ArrayList<>();
		listaPizzas.add(insertPizzas("Pizza Margerita (tomato, cheese)", 4.99, 1104));
		listaPizzas.add(insertPizzas("Hawaiian Pizza (tomato, cheese, ham, pineapple)", 6.49, 1024));
		listaPizzas.add(insertPizzas("Salami Pizza (tomato, cheese, salami)", 5.99, 1160));
		for(Pizzas pizza : listaPizzas) {
			pizza.stampaPizzas();
		}
		System.out.println("Family Size for Pizza - CALORIES: x1.95 PRICE: +4.15$");
		System.out.println();
		System.out.println("TOPPINGS");
		System.out.println();
		List<Toppings> listaTopping = new ArrayList<>();
		listaTopping.add(insertToppings("Cheese", 0.69, 92));
		listaTopping.add(insertToppings("Ham", 0.99, 35));
		listaTopping.add(insertToppings("Onions", 0.69, 22));
		listaTopping.add(insertToppings("Pineapple", 0.79, 24));
		listaTopping.add(insertToppings("Salami", 0.99, 86));
		for(Toppings topping : listaTopping) {
			topping.stampaToppings();
		}
		System.out.println();
		System.out.println("DRINKS");
		System.out.println();
		List<Drinks> listaDrinks = new ArrayList<>();
		listaDrinks.add(insertDrinks("Lemonade (0,33l)", 1.29, 128));
		listaDrinks.add(insertDrinks("Water (0,5l)", 1.29, 0));
		listaDrinks.add(insertDrinks("Wine (0,75l, 13%)", 7.49, 607));
		for(Drinks drink : listaDrinks) {
			drink.stampaDrinks();
		}
		System.out.println();
		System.out.println("FRANCHISE");
		System.out.println();
		List<Franchise> listaFranchise = new ArrayList<>();
		listaFranchise.add(insertFranchise("Shirt", 21.99));
		listaFranchise.add(insertFranchise("Mug", 4.99));
		for(Franchise franchise : listaFranchise) {
			franchise.stampaFranchise();
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("TAVOLI");
		System.out.println();
		List<Tavolo> listaTavoli = new ArrayList<>();
		listaTavoli.add(insertTavolo(1, 4));
		listaTavoli.add(insertTavolo(2, 3));
		listaTavoli.add(insertTavolo(3, 6));
		listaTavoli.add(insertTavolo(4, 4));
		for(Tavolo tavolo: listaTavoli) {
			tavolo.stampaTavolo();
		}
		
		List<Prodotto> listaOrdine1 = new ArrayList<>();
		listaOrdine1.addAll(listaPizzas);
		Ordine ordine1 = insertOrdine(1, listaOrdine1, 3, listaTavoli.get(0));
		ordine1.stampaOrdine();
		
	}

	public static Toppings insertToppings(String nome, double prezzo, long calorie) {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigurationProdotto.class);
		
		Toppings topping = (Toppings) appCtx.getBean("topping", nome, prezzo, calorie);
		
		((AnnotationConfigApplicationContext) appCtx).close();
		return topping;
	}
	
	public static Pizzas insertPizzas(String nome, double prezzo, long calorie) {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigurationProdotto.class);
		
		Pizzas pizza = (Pizzas) appCtx.getBean("pizza", nome, prezzo, calorie);
		
		((AnnotationConfigApplicationContext) appCtx).close();
		return pizza;
	}
	
	public static Drinks insertDrinks(String nome, double prezzo, long calorie) {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigurationProdotto.class);
		
		Drinks drink = (Drinks) appCtx.getBean("drink", nome, prezzo, calorie);
		
		((AnnotationConfigApplicationContext) appCtx).close();
		return drink;
	}
	
	public static Franchise insertFranchise(String nome, double prezzo) {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigurationProdotto.class);
		
		Franchise franchise = (Franchise) appCtx.getBean("franchise", nome, prezzo);
		
		((AnnotationConfigApplicationContext) appCtx).close();
		return franchise;
	}

	public static Tavolo insertTavolo(int numeroTavolo, int numeroMaxCoperti) {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigurationGestioneOrdini.class);
		
		Tavolo tavolo = (Tavolo) appCtx.getBean("tavolo", numeroTavolo, numeroMaxCoperti);
		
		((AnnotationConfigApplicationContext) appCtx).close();
		return tavolo;
	}
	
	public static Ordine insertOrdine(int numeroOrdine, List<Prodotto> listaProdotti, int numeroCoperti, Tavolo tavolo) {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigurationGestioneOrdini.class);
		
		Ordine ordine = (Ordine) appCtx.getBean("ordine", numeroOrdine, listaProdotti, numeroCoperti, tavolo);
		
		((AnnotationConfigApplicationContext) appCtx).close();
		return ordine;
	}
}
