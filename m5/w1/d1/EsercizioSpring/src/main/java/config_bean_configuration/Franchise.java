package config_bean_configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Franchise extends Prodotto{
	
	public Franchise(String nome, double prezzo) {
		super(nome, prezzo);
	}

	public void stampaFranchise() {
		System.out.println(super.getNomeProdotto() + " - PRICE: " + super.getPrezzo());
	}
}
