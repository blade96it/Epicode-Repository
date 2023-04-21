package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Edificio;
import com.example.demo.repository.EdificioDAORepository;

@Service
public class EdificioService {

	@Autowired EdificioDAORepository repo;
	
	public void insertEdificio(Edificio edificio) {
		repo.save(edificio);
	}
	
	public Edificio getEdificioByID(Long id) {
		return repo.findById(id).get();
	}
	
	public void updateEdificio(Edificio edificio) {
		repo.save(edificio);
	}
	
	public void removeEdificio(Edificio edificio) {
		repo.delete(edificio);
	}
	
	public List<Edificio> getAllEdificio() {
		return (List<Edificio>) repo.findAll();
	}
}
