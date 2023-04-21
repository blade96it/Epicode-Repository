package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
public class Biglietti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_biglietto;
	
	@ManyToOne
	@JoinColumn(name = "id_rivenditore")
	private RivenditoriAutorizzati rivenditore;
	
	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Utente utente;
	
	public Biglietti() {}
	

	public Long getId_biglietto() {
		return id_biglietto;
	}


	public RivenditoriAutorizzati getRivenditore() {
		return rivenditore;
	}


	public void setRivenditore(RivenditoriAutorizzati rivenditore) {
		this.rivenditore = rivenditore;
	}


	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}
