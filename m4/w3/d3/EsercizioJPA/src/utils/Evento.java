package utils;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="\"Evento\"")
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"idEvento\"")
	private Integer idEvento;

	@Column(name="\"dataEvento\"")
	private Integer dataEvento;

	private String descrizione;

	@Column(name="\"numeroMassimoPartecipanti\"")
	private Integer numeroMassimoPartecipanti;

	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;

	private String titolo;

	public Evento() {
	}
	
	public Evento(Integer dataEvento, String descrizione, Integer numeroMassimoPartecipanti, TipoEvento tipoEvento, String titolo) {
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.tipoEvento = tipoEvento;
		this.titolo = titolo;
	}
	

	public Integer getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public Integer getDataEvento() {
		return this.dataEvento;
	}

	public void setDataEvento(Integer dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getNumeroMassimoPartecipanti() {
		return this.numeroMassimoPartecipanti;
	}

	public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	public TipoEvento getTipoevento() {
		return this.tipoEvento;
	}

	public void setTipoevento(TipoEvento tipoevento) {
		this.tipoEvento = tipoevento;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
				+ ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti + ", tipoEvento=" + tipoEvento
				+ ", titolo=" + titolo + "]";
	}

}