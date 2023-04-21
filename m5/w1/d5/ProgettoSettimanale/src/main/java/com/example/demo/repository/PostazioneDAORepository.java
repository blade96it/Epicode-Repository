package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Postazione;
import com.example.demo.model.TipoPostazione;

@Repository
public interface PostazioneDAORepository extends JpaRepository<Postazione, Long> {

	@Query(value = "SELECT * FROM postazione INNER JOIN edificio ON "
			+ "postazione.edificio = edificio.id_edificio WHERE edificio.citta = :citta AND postazione.tipo = :tipo",
			nativeQuery = true)
	List<Postazione> cerca(
			@Param("citta") String citta, @Param("tipo") TipoPostazione tipo);
}
