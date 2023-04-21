package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BigliettiEmessi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_biglietti_emessi;
	
	@Column(nullable = false)
	private LocalDate data_emissione;
	
	@ManyToOne
	@JoinColumn(name = "id_distributore")
	private Distributori distributore;
	
	public BigliettiEmessi() {};
	
	public BigliettiEmessi(Distributori distributore) {
		this.data_emissione = LocalDate.now();
		this.distributore = distributore;
	}

	public Long getId_biglietti_emessi() {
		return id_biglietti_emessi;
	}

	public void setId_biglietti_emessi(Long id_biglietti_emessi) {
		this.id_biglietti_emessi = id_biglietti_emessi;
	}

	public LocalDate getData_emissione() {
		return data_emissione;
	}

	public Distributori getDistributore() {
		return distributore;
	}
	
}
