package com.example.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Edificio;
import com.example.demo.model.Postazione;
import com.example.demo.model.TipoPostazione;
import com.example.demo.service.EdificioService;
import com.example.demo.service.PostazioneService;

@Component
public class PostazioneRunner implements ApplicationRunner {

	@Autowired PostazioneService postazioneService;
	@Autowired EdificioService edificioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("Postazione running...");
		
		Edificio e1 = edificioService.getEdificioByID(1L);
		Edificio e2 = edificioService.getEdificioByID(2L);
		Postazione p1 = new Postazione("Sala Studio", TipoPostazione.OPENSPACE, 30, e1);
		Postazione p2 = new Postazione("Sala Riunioni Principale", TipoPostazione.SALA_RIUNIONI, 20, e2);
		Postazione p3 = new Postazione("Postazione base", TipoPostazione.PRIVATO, 4, e1);
		Postazione p4 = new Postazione("Postazione base", TipoPostazione.PRIVATO, 2, e1);
		Postazione p5 = new Postazione("Postazione base", TipoPostazione.PRIVATO, 5, e2);
		
//		postazioneService.insertPostazione(p1);
//		postazioneService.insertPostazione(p2);
//		postazioneService.insertPostazione(p3);
//		postazioneService.insertPostazione(p4);
//		postazioneService.insertPostazione(p5);
		
		//Con queste righe di codice ricerco le postazioni per città e preferenza di tipo
//		List<Postazione> lista = postazioneService.cercaPerCittaPreferenza("Sassari", TipoPostazione.PRIVATO);
//		lista.forEach(p -> System.out.println(p.getDescrizione()));

	}

}
