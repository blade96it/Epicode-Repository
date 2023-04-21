package config_bean_configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigurationProdotto {
	
	@Bean
	@Scope("prototype")
	public Toppings topping(String nome, double prezzo, long calorie) {
		return new Toppings(nome, prezzo, calorie);
	}
	
	@Bean
	@Scope("prototype")
	public Pizzas pizza(String nome, double prezzo, long calorie) {
		return new Pizzas(nome, prezzo, calorie);
	}
	
	@Bean
	@Scope("prototype")
	public Pizzas pizzaConTopping(String nome, double prezzo, long calorie, Toppings topping) {
		return new Pizzas(nome, prezzo, calorie, topping);
	}
	
	@Bean
	@Scope("prototype")
	public Drinks drink(String nome, double prezzo, long calorie) {
		return new Drinks(nome, prezzo, calorie);
	}
	
	@Bean
	@Scope("prototype")
	public Franchise franchise(String nome, double prezzo) {
		return new Franchise(nome, prezzo);
	}
	
}
