package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteDAORepository;

@Service
public class UtenteService {

	@Autowired UtenteDAORepository repo;
	
	public void insertUtente(Utente utente) {
		repo.save(utente);
	}
	
	public Utente getUtenteByID(Long id) {
		return repo.findById(id).get();
	}
	
	public void updateUtente(Utente utente) {
		repo.save(utente);
	}
	
	public void removeUtente(Utente utente) {
		repo.delete(utente);
	}
	
	public List<Utente> getAllUtente() {
		return (List<Utente>) repo.findAll();
	}
}
