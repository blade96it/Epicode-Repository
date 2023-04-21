package config_bean_configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Drinks extends Prodotto{

	private long calorie;
	
	public Drinks(String nome, double prezzo, long calorie) {
		super(nome, prezzo);
		this.calorie = calorie;
	}
	
	public void stampaDrinks() {
		System.out.println(super.getNomeProdotto() + " - CALORIES: " + this.calorie + " PRICE: " + super.getPrezzo());
	}
}
