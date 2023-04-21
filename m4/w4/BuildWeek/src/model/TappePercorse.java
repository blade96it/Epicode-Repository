package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TappePercorse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tappe_percorse;
	
	@Column(nullable = false)
	private long tempo_percorrenza;
	
	@ManyToOne
	@JoinColumn(name = "id_mezzo")
	private ParcoMezzi mezzo;
	
	public TappePercorse() {}
	
	public TappePercorse(ParcoMezzi mezzo, long tempo_percorrenza) {
		this.mezzo = mezzo;
		this.tempo_percorrenza = tempo_percorrenza;
	}
	
	public Long getId_tappe_percorse() {
		return id_tappe_percorse;
	}

	public long getTempo_percorrenza() {
		return tempo_percorrenza;
	}

	public ParcoMezzi getMezzo() {
		return mezzo;
	}
	
}
