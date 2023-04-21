package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Postazione;
import com.example.demo.model.TipoPostazione;
import com.example.demo.repository.PostazioneDAORepository;

@Service
public class PostazioneService {

	@Autowired PostazioneDAORepository repo;
	
	public void insertPostazione(Postazione postazione) {
		repo.save(postazione);
	}
	
	public Postazione getPostazioneByID(Long id) {
		return repo.findById(id).get();
	}
	
	public void updatePostazione(Postazione postazione) {
		repo.save(postazione);
	}
	
	public void removePostazione(Postazione postazione) {
		repo.delete(postazione);
	}
	
	public List<Postazione> getAllPostazione() {
		return (List<Postazione>) repo.findAll();
	}
	
	public List<Postazione> cercaPerCittaPreferenza(String citta, TipoPostazione tipo) {
		return (List<Postazione>) repo.cerca(citta, tipo);
	}
}
