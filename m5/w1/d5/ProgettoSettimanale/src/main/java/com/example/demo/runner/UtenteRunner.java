package com.example.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Edificio;
import com.example.demo.model.Postazione;
import com.example.demo.model.TipoPostazione;
import com.example.demo.model.Utente;
import com.example.demo.service.EdificioService;
import com.example.demo.service.PostazioneService;
import com.example.demo.service.UtenteService;

@Component
public class UtenteRunner implements ApplicationRunner {

	@Autowired UtenteService utenteService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("Utente running...");
		
		Utente u1 = new Utente("marieddu65", "Mario Rossi", "mario.rossi@example.com");
		Utente u2 = new Utente("lucassu78", "Luca Neri", "luca.neri@example.com");
		Utente u3 = new Utente("cesca00", "Francesca Bianchi", "francesca.bianchi@example.com");
		Utente u4 = new Utente("cioletta98", "Luisa Viola", "luisa.viola@example.com");
		Utente u5 = new Utente("blade96it", "Manuel Gadau", "manuel.gadau@example.com");
		
//		utenteService.insertUtente(u1);
//		utenteService.insertUtente(u2);
//		utenteService.insertUtente(u3);
//		utenteService.insertUtente(u4);
//		utenteService.insertUtente(u5);

	}

}
