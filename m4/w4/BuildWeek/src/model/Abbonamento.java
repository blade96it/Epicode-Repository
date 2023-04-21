package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import utils.TipologiaAbbonamento;

@Entity
public class Abbonamento extends Biglietti {

	private String nominativo;
	
	@Enumerated(EnumType.STRING)
	private TipologiaAbbonamento tipologia_abbonamento;
	
	private LocalDate data_attivazione_abbonamento;
	private LocalDate data_scadenza_abbonamento;
	
	public Abbonamento() {
		super();
	}
	
	public Abbonamento(TipologiaAbbonamento tipologia_abbonamento) {
		super();
		this.tipologia_abbonamento = tipologia_abbonamento;		
	}
	
	public Abbonamento(String nominativo, TipologiaAbbonamento tipologia_abbonamento) {
		super();
		this.nominativo = nominativo;
		this.tipologia_abbonamento = tipologia_abbonamento;		
	}

	@Override
	public Long getId_biglietto() {
		// TODO Auto-generated method stub
		return super.getId_biglietto();
	}
	
	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public String getNominativo() {
		return nominativo;
	}

	public TipologiaAbbonamento getTipologia_abbonamento() {
		return tipologia_abbonamento;
	}

	public LocalDate getData_attivazione_abbonamento() {
		return data_attivazione_abbonamento;
	}

	public void setData_attivazione_abbonamento() {
		this.data_attivazione_abbonamento = LocalDate.now();
		this.setData_scadenza_abbonamento();
	}

	public LocalDate getData_scadenza_abbonamento() {
		return data_scadenza_abbonamento;
	}

	public void setData_scadenza_abbonamento() {
		if(this.tipologia_abbonamento == TipologiaAbbonamento.SETTIMANALE) {
			this.data_scadenza_abbonamento = this.data_attivazione_abbonamento.plusWeeks(1);
		}
		else {
			this.data_scadenza_abbonamento = this.data_attivazione_abbonamento.plusMonths(1);
		}
	}

}
