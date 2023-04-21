package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Edificio;

@Repository
public interface EdificioDAORepository extends JpaRepository<Edificio, Long> {

}
