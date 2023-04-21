package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_prenotazione;
	
	private LocalDate data_attivazione;
	private LocalDate data_disattivazione;
	
	@OneToOne
	@JoinColumn(name = "postazione")
	private Postazione postazione;
	
	@ManyToOne
	@JoinColumn(name = "utente")
	private Utente utente;
	
	public Prenotazione(String dataPrenotazione, Postazione postazione, Utente utente) {
		this.data_attivazione = LocalDate.parse(dataPrenotazione);
		this.data_disattivazione = this.data_attivazione.plusDays(1);
		this.postazione = postazione;
		this.utente = utente;
	}
}
