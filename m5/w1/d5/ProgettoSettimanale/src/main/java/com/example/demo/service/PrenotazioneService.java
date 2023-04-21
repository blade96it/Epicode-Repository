package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Prenotazione;
import com.example.demo.repository.PrenotazioneDAORepository;

@Service
public class PrenotazioneService {

	@Autowired PrenotazioneDAORepository repo;
	
	public void insertPrenotazione(Prenotazione prenotazione) {
		repo.save(prenotazione);
	}
	
	public Prenotazione getPrenotazioneByID(Long id) {
		return repo.findById(id).get();
	}
	
	public void updatePrenotazione(Prenotazione prenotazione) {
		repo.save(prenotazione);
	}
	
	public void removePrenotazione(Prenotazione prenotazione) {
		repo.delete(prenotazione);
	}
	
	public List<Prenotazione> getAllPrenotazione() {
		return (List<Prenotazione>) repo.findAll();
	}
}
