package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Prenotazione;

@Repository
public interface PrenotazioneDAORepository extends JpaRepository<Prenotazione, Long> {

}
