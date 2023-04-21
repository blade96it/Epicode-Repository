package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Edificio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_edificio;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String indirizzo;
	
	@Column(nullable = false)
	private String citta;
	
	@OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
	private List<Postazione> postazioni;
	
	public Edificio(String nome, String citta, String indirizzo) {
		this.nome = nome;
		this.citta = citta;
		this.indirizzo = indirizzo;
	}
}
