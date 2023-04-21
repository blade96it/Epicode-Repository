package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import utils.StatoMezzo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ParcoMezzi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_parco_mezzi;
	
	@Column(nullable = false)
	private int capienza;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatoMezzo stato;
	
	private LocalDate data_inizio_servizio;
	private LocalDate data_fine_servizio;
	private LocalDate data_inizio_manutenzione;
	private LocalDate data_fine_manutenzione;
	
	@ManyToOne
	@JoinColumn(name = "id_tratta")
	private Tratta tratta;
	
	public ParcoMezzi() {}
	
	public ParcoMezzi(int capienza, Tratta tratta) {
		this.capienza = capienza;
		this.tratta = tratta;
		this.stato = StatoMezzo.SERVIZIO;
		this.data_inizio_servizio = LocalDate.now();
	}
	
	public StatoMezzo getStato() {
		return stato;
	}

	public void setStato(StatoMezzo stato) {
		this.stato = stato;
		if(stato == StatoMezzo.SERVIZIO) {
			this.setData_inizio_servizio();
			this.setData_fine_manutenzione();
			this.data_fine_servizio = null;
		}
		else {
			this.setData_inizio_manutenzione();
			this.setData_fine_servizio();
			this.data_fine_manutenzione = null;
		}
	}

	public LocalDate getData_inizio_servizio() {
		return data_inizio_servizio;
	}

	public void setData_inizio_servizio() {
		this.data_inizio_servizio = LocalDate.now();
	}

	public LocalDate getData_fine_servizio() {
		return data_fine_servizio;
	}

	public void setData_fine_servizio() {
		this.data_fine_servizio = LocalDate.now();
	}

	public LocalDate getData_inizio_manutenzione() {
		return data_inizio_manutenzione;
	}

	public void setData_inizio_manutenzione() {
		this.data_inizio_manutenzione = LocalDate.now();
	}

	public LocalDate getData_fine_manutenzione() {
		return data_fine_manutenzione;
	}

	public void setData_fine_manutenzione() {
		this.data_fine_manutenzione = LocalDate.now();
	}

	public Tratta getTratta() {
		return tratta;
	}

	public void setTratta(Tratta tratta) {
		this.tratta = tratta;
	}

	public Long getId_parco_mezzi() {
		return id_parco_mezzi;
	}

	public int getCapienza() {
		return capienza;
	}
	
}
