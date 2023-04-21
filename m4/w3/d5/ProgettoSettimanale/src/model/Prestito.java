package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Prestito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrestito;
	
	@ManyToOne
	@JoinColumn(name = "numero_tessera")
	private Utente utente;
	
	@OneToOne
    @JoinColumn(name = "codiceISBN")
	private Catalogo elementoPrestato;
	
	//UTILIZZO L'OGGETTO DI TIPO LOCALDATE PER POTER AVERE UNA DATA IN FORMATO YYYY/DD/MM. 
	//CON DATAINIZIOPRESTITO, QUANDO VIENE ISTANZIATO L'OGGETTO DI TIPO PRESTITO, VIENE ASSEGNATA LA DATA ODIERNA. NELLA DATARESTITUIZIONEPREVISTA AGGIUNGO
	//ALLA DATA DELL'INIZIO DEL PRESTITO 30 GIORNI, COSICCHE' IL SISTEMA AUTOMATIZZI LA SCADENZA DEL PRESTITO UNA VOLTA CHE L'OGGETTO VIENE ISTANZIATO
	//LA DATARESTITUIZIONEEFFETTIVA INVECE VERRA' AGGIUNTA MANUALMENTE UNA VOLTA CHE L'ELEMENTO DEL CATALOGO VERRA' RESTITUITO.
	
	private LocalDate dataInizioPrestito;	
	private LocalDate DataRestituizionePrevista;
	private LocalDate DataRestituizioneEffetiva;
	
	public Prestito() {
		this.dataInizioPrestito = LocalDate.now();
		this.DataRestituizionePrevista = this.dataInizioPrestito.plusDays(30);
	};
	
	public Prestito(Utente utente, Catalogo elementoPrestato) {
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = LocalDate.now();
		this.DataRestituizionePrevista = this.dataInizioPrestito.plusDays(30);
	}

	public Long getIdPrestito() {
		return idPrestito;
	}

	public void setIdPrestito(Long idPrestito) {
		this.idPrestito = idPrestito;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Catalogo getElementoPrestato() {
		return elementoPrestato;
	}

	public void setElementoPrestato(Catalogo elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}

	public LocalDate getDataInizioPrestito() {
		return dataInizioPrestito;
	}

	public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}

	public LocalDate getDataRestituizionePrevista() {
		return DataRestituizionePrevista;
	}

	public void setDataRestituizionePrevista(LocalDate dataRestituizionePrevista) {
		DataRestituizionePrevista = dataRestituizionePrevista;
	}

	public LocalDate getDataRestituizioneEffetiva() {
		return DataRestituizioneEffetiva;
	}

	public void setDataRestituizioneEffetiva(LocalDate dataRestituizioneEffetiva) {
		DataRestituizioneEffetiva = dataRestituizioneEffetiva;
	}
	
}
