package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Rivista extends Catalogo{

	@Enumerated(EnumType.STRING)
	private Periodicità periodicita;
	
	public Rivista () {
		super();
	}
	
	public Rivista(String titolo, Integer annoPubblicazione, Integer numeroPagine, Periodicità periodicita) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	public Periodicità getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicità periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public Long getCodiceISBN() {
		// TODO Auto-generated method stub
		return super.getCodiceISBN();
	}

	@Override
	public void setCodiceISBN(Long codiceISBN) {
		// TODO Auto-generated method stub
		super.setCodiceISBN(codiceISBN);
	}

	@Override
	public String getTitolo() {
		// TODO Auto-generated method stub
		return super.getTitolo();
	}

	@Override
	public void setTitolo(String titolo) {
		// TODO Auto-generated method stub
		super.setTitolo(titolo);
	}

	@Override
	public Integer getAnnoPubblicazione() {
		// TODO Auto-generated method stub
		return super.getAnnoPubblicazione();
	}

	@Override
	public void setAnnoPubblicazione(Integer annoPubblicazione) {
		// TODO Auto-generated method stub
		super.setAnnoPubblicazione(annoPubblicazione);
	}

	@Override
	public Integer getNumeroPagine() {
		// TODO Auto-generated method stub
		return super.getNumeroPagine();
	}

	@Override
	public void setNumeroPagine(Integer numeroPagine) {
		// TODO Auto-generated method stub
		super.setNumeroPagine(numeroPagine);
	}
	
	
}
