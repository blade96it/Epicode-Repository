package com.example.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Edificio;
import com.example.demo.service.EdificioService;

@Component
public class EdificioRunner implements ApplicationRunner {

	@Autowired EdificioService edificioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("Edificio running...");
		
		Edificio edificio1 = new Edificio("Biblioteca Pigliaru", "Sassari", "Viale Pasquale Stanislao Mancini, 1");
		Edificio edificio2 = new Edificio("Biblioteca Comunale", "Sassari", "Piazza Tola, 1");
		
//		edificioService.insertEdificio(edificio1);
//		edificioService.insertEdificio(edificio2);
	}

}
