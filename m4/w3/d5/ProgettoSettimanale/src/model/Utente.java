package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero_tessera;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private LocalDate dataNascita;
	
	@OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
	private List<Prestito> prestiti;
	
	public Utente() {}
	
	public Utente(String nome, String cognome, String dataInput) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = LocalDate.parse(dataInput);
	}

	public Long getNumeroTessera() {
		return numero_tessera;
	}

	public void setNumeroTessera(Long numeroTessera) {
		this.numero_tessera = numeroTessera;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "Utente [numero_tessera=" + numero_tessera + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita="
				+ dataNascita + ", prestiti=" + prestiti + "]";
	}
	
	
	
}
