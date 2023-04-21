package model;

import javax.persistence.Entity;

@Entity
public class Libro extends Catalogo {

	private String autore;
	private String genere;
	
	public Libro() {
		super();
	}
	
	public Libro(String titolo, Integer annoPubblicazione, Integer numeroPagine, String autore, String genere) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
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
