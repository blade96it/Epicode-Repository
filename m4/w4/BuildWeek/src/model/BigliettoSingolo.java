package model;

import javax.persistence.Entity;

@Entity
public class BigliettoSingolo extends Biglietti{
	
	public BigliettoSingolo() {
		super();
	}

	@Override
	public Long getId_biglietto() {
		// TODO Auto-generated method stub
		return super.getId_biglietto();
	}
}
