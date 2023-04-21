package config_bean_configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Toppings extends Prodotto{

	private long calorie;
	
	public Toppings(String nome, double prezzo, long calorie) {
		super(nome, prezzo);
		this.calorie = calorie;
	}
	
	public void stampaToppings() {
		System.out.println(super.getNomeProdotto() + " - CALORIES: " + this.calorie + " PRICE: " + super.getPrezzo() + "$");
	}
}
