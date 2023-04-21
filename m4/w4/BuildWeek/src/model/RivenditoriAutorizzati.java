package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class RivenditoriAutorizzati extends Distributori{

	private String nome_titolare;
	private String cognome_titolare;
	private String p_iva_titolare;

	@OneToMany(mappedBy = "rivenditore")
	private List<Biglietti> biglietti;
	
	public RivenditoriAutorizzati() {};
	
	public RivenditoriAutorizzati(String citta, String indirizzo, String nome_titolare, String cognome_titolare, String p_iva_titolare) {
		super(citta, indirizzo);
		this.nome_titolare = nome_titolare;
		this.cognome_titolare = cognome_titolare;
		this.p_iva_titolare = p_iva_titolare;
	}

	@Override
	public Long getId_distributore() {
		// TODO Auto-generated method stub
		return super.getId_distributore();
	}

	@Override
	public String getCitta() {
		// TODO Auto-generated method stub
		return super.getCitta();
	}

	@Override
	public String getIndirizzo() {
		// TODO Auto-generated method stub
		return super.getIndirizzo();
	}

	public List<Biglietti> getBiglietti() {
		return biglietti;
	}

	public void setBiglietti(List<Biglietti> biglietti) {
		this.biglietti = biglietti;
	}

	public String getNome_titolare() {
		return nome_titolare;
	}

	public String getCognome_titolare() {
		return cognome_titolare;
	}

	public String getP_iva_titolare() {
		return p_iva_titolare;
	}
	
	
}
