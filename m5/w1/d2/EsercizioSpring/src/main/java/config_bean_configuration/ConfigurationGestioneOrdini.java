package config_bean_configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigurationGestioneOrdini {

	@Bean
	@Scope("prototype")
	public Tavolo tavolo(int numeroTavolo, int numeroMaxCoperti) {
		return new Tavolo(numeroTavolo, numeroMaxCoperti);
	}
	
	@Bean
	@Scope("prototype")
	public Ordine ordine(int numeroOrdine, List<Prodotto> listaProdotti, int numeroCoperti, Tavolo tavolo) {
		return new Ordine(numeroOrdine, listaProdotti, numeroCoperti, tavolo);
	}
}
