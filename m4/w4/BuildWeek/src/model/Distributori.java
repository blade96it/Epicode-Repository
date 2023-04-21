package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Distributori {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_distributore;
	
	@Column(nullable = false)
	private String citta;
	
	@Column(nullable = false)
	private String indirizzo;
	
	public Distributori() {}
	
	public Distributori(String citta, String indirizzo) {
		this.citta = citta;
		this.indirizzo = indirizzo;
	}

	public Long getId_distributore() {
		return id_distributore;
	}

	public String getCitta() {
		return citta;
	}

	public String getIndirizzo() {
		return indirizzo;
	};
	
}
