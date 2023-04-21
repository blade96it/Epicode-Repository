package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Utente;

@Repository
public interface UtenteDAORepository extends JpaRepository<Utente, Long> {
}
