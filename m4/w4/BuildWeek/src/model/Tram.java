package model;

import java.time.LocalDate;

import javax.persistence.Entity;

import utils.StatoMezzo;

@Entity
public class Tram extends ParcoMezzi{

	public Tram() {}
	
	public Tram(int capienza, Tratta tratta) {
		super(capienza, tratta);
	}
	
	@Override
	public StatoMezzo getStato() {
		// TODO Auto-generated method stub
		return super.getStato();
	}

	@Override
	public void setStato(StatoMezzo stato) {
		// TODO Auto-generated method stub
		super.setStato(stato);
	}

	@Override
	public LocalDate getData_inizio_servizio() {
		// TODO Auto-generated method stub
		return super.getData_inizio_servizio();
	}

	@Override
	public void setData_inizio_servizio() {
		// TODO Auto-generated method stub
		super.setData_inizio_servizio();
	}

	@Override
	public LocalDate getData_fine_servizio() {
		// TODO Auto-generated method stub
		return super.getData_fine_servizio();
	}

	@Override
	public void setData_fine_servizio() {
		// TODO Auto-generated method stub
		super.setData_fine_servizio();
	}

	@Override
	public LocalDate getData_inizio_manutenzione() {
		// TODO Auto-generated method stub
		return super.getData_inizio_manutenzione();
	}

	@Override
	public void setData_inizio_manutenzione() {
		// TODO Auto-generated method stub
		super.setData_inizio_manutenzione();
	}

	@Override
	public LocalDate getData_fine_manutenzione() {
		// TODO Auto-generated method stub
		return super.getData_fine_manutenzione();
	}

	@Override
	public void setData_fine_manutenzione() {
		// TODO Auto-generated method stub
		super.setData_fine_manutenzione();
	}

	@Override
	public Tratta getTratta() {
		// TODO Auto-generated method stub
		return super.getTratta();
	}

	@Override
	public void setTratta(Tratta tratta) {
		// TODO Auto-generated method stub
		super.setTratta(tratta);
	}

	@Override
	public Long getId_parco_mezzi() {
		// TODO Auto-generated method stub
		return super.getId_parco_mezzi();
	}

	@Override
	public int getCapienza() {
		// TODO Auto-generated method stub
		return super.getCapienza();
	}
}
