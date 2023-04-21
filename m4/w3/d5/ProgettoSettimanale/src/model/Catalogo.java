package model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Catalogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codiceISBN;
	
	@Column(nullable = false)
	private String titolo;
	
	@Column(nullable = false)
	private Integer annoPubblicazione;
	
	@Column(nullable = false)
	private Integer numeroPagine;
	
	@OneToOne(mappedBy = "elementoPrestato", cascade = CascadeType.ALL)
	private Prestito prestito;
	
	public Catalogo() {
		super();
	}
	
	public Catalogo(String titolo, Integer annoPubblicazione, Integer numeroPagine) {
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public Long getCodiceISBN() {
		return codiceISBN;
	}

	public void setCodiceISBN(Long codiceISBN) {
		this.codiceISBN = codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(Integer annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public Integer getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(Integer numeroPagine) {
		this.numeroPagine = numeroPagine;
	}
	
	
}
