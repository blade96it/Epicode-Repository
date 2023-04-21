package com.example.demo.model;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_utente;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String nome_completo;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "utente", cascade = CascadeType.ALL)
	private Collection<Prenotazione> prenotazioni = new LinkedHashSet<Prenotazione>();
	
	public Utente(String username, String nome_completo, String email) {
		this.username = username;
		this.nome_completo = nome_completo;
		this.email = email;
	}
	
	public Collection<Prenotazione> getPrenotazioni() {
		return this.prenotazioni;
	}
}
