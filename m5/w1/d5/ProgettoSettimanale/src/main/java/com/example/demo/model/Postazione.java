package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Postazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_postazione;
	
	@Column(nullable = false)
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoPostazione tipo;
	
	@Column(nullable = false)
	private int max_occupanti;
	
	@ManyToOne
	@JoinColumn(name = "edificio")
	private Edificio edificio;
	
	@OneToOne
	@JoinColumn(name = "prenotazione")
	private Prenotazione prenotazione;
	
	public Postazione(String descrizione, TipoPostazione tipo, int max_occupanti, Edificio edificio) {
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.max_occupanti = max_occupanti;
		this.edificio = edificio;
	}
}
