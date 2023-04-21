package config_bean_configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Pizzas extends Prodotto{

	private long calorie;
	private Toppings topping;
	
	public Pizzas(String nome, double prezzo, long calorie) {
		super(nome, prezzo);
		this.calorie = calorie;
	}
	
	public Pizzas(String nome, double prezzo, long calorie, Toppings topping) {
		super(nome, prezzo);
		this.calorie = calorie;
		this.topping = topping;
	}
	
	public void stampaPizzas() {
		System.out.println(super.getNomeProdotto() + " - CALORIES: " + this.calorie + " PRICE: " + super.getPrezzo());
	}
}
