package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Tessera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tessera;
	
	@OneToOne(mappedBy = "tessera")
	@JoinColumn(name = "id_utente")
	private Utente utente;
	
	@Column(nullable = false)
	private LocalDate data_attivazione;
	
	@Column(nullable = false)
	private LocalDate data_scadenza;
	
	public Tessera() {
		this.data_attivazione = LocalDate.now();
		this.data_scadenza = this.data_attivazione.plusYears(1);
	}

	public Long getId_tessera() {
		return id_tessera;
	}

	public Utente getUtente() {
		return utente;
	}

	public LocalDate getData_attivazione() {
		return data_attivazione;
	}

	public LocalDate getData_scadenza() {
		return data_scadenza;
	}
	
}
