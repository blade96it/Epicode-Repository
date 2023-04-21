package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_utente;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false , unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false , unique = true)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_tessera" , unique = true)
	private Tessera tessera;
	
	@OneToOne
	@JoinColumn(name = "id_abbonamento", unique = true)
	private Abbonamento abbonamento;
	
	@OneToMany(mappedBy = "utente")
	private List<BigliettoSingolo> biglietto_singolo;
	
	public Utente() {};
	
	public Utente(String nome, String cognome, String username, String password, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Abbonamento getAbbonamento() {
		return abbonamento;
	}

	public void setAbbonamento(Abbonamento abbonamento) {
		this.abbonamento = abbonamento;
	}

	public Long getId_utente() {
		return id_utente;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public List<BigliettoSingolo> getBiglietto_singolo() {
		return biglietto_singolo;
	}

	public void setBiglietto_singolo(List<BigliettoSingolo> biglietto_singolo) {
		this.biglietto_singolo = biglietto_singolo;
	}
	
}
