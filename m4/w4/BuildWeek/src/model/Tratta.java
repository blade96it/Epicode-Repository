package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tratta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tratta;
	
	@Column(nullable = false)
	private String zona_di_partenza;
	
	@Column(nullable = false)
	private String capolinea;
	
	private long tempo_medio_percorrenza;
	
	@OneToMany(mappedBy = "tratta")
	private List<ParcoMezzi> mezzo;
	
	public Tratta() {}
	
	public Tratta(String zona_di_partenza, String capolinea) {
		this.zona_di_partenza = zona_di_partenza;
		this.capolinea = capolinea;
	}
	
	public long getTempo_medio_percorrenza() {
		return tempo_medio_percorrenza;
	}

	public void setTempo_medio_percorrenza(long tempo_medio_percorrenza) {
		this.tempo_medio_percorrenza = tempo_medio_percorrenza;
	}

	public Long getId_tratta() {
		return id_tratta;
	}

	public String getZona_di_partenza() {
		return zona_di_partenza;
	}

	public String getCapolinea() {
		return capolinea;
	}
}
