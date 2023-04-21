package com.example.demo.runner;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Edificio;
import com.example.demo.model.Postazione;
import com.example.demo.model.Prenotazione;
import com.example.demo.model.TipoPostazione;
import com.example.demo.model.Utente;
import com.example.demo.service.EdificioService;
import com.example.demo.service.PostazioneService;
import com.example.demo.service.PrenotazioneService;
import com.example.demo.service.UtenteService;

@Component
public class PrenotazioneRunner implements ApplicationRunner {

	@Autowired PrenotazioneService prenotazioneService;
	@Autowired PostazioneService postazioneService;
	@Autowired UtenteService utenteService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("Prenotazione running...");
		
//		Postazione p1 = postazioneService.getPostazioneByID(1L);
//		Postazione p2 = postazioneService.getPostazioneByID(2L);
//		Postazione p3 = postazioneService.getPostazioneByID(3L);
//		Postazione p4 = postazioneService.getPostazioneByID(4L);
//		Postazione p5 = postazioneService.getPostazioneByID(5L);
//		
//		Utente u1 = utenteService.getUtenteByID(1L);
//		Utente u2 = utenteService.getUtenteByID(2L);
//		Utente u3 = utenteService.getUtenteByID(3L);
//		Utente u4 = utenteService.getUtenteByID(4L);
//		Utente u5 = utenteService.getUtenteByID(5L);
//		
//		LocalDate dataOdierna = LocalDate.now();
//		Prenotazione pre1 = new Prenotazione("2023-03-08",p1, u1);
		
//		if(p1.getPrenotazione() == null) {
//			prenotazioneService.insertPrenotazione(pre1);
//			p1.setPrenotazione(pre1);
//			postazioneService.updatePostazione(p1);
//		}
//		else {
//			System.out.println("Postazione già prenotata!");
//		}
		
//		pre1 = prenotazioneService.getPrenotazioneByID(1L);
//		prenotazioneService.removePrenotazione(pre1);
		
	}

}
