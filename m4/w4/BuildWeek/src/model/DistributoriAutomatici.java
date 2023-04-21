package model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DistributoriAutomatici extends Distributori{

	private boolean fuori_servizio;
	
	public DistributoriAutomatici() {};
	
	public DistributoriAutomatici(String citta, String indirizzo) {
		super(citta, indirizzo);
		this.fuori_servizio = false;
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

	public boolean isFuori_servizio() {
		return fuori_servizio;
	}
	
	public void setFuori_servizio(boolean fuori_servizio) {
		this.fuori_servizio = fuori_servizio;
	}
	
}
