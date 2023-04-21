package pack1;

public class Dipendente {
	
	private static double stipendioBase = 1000;
	private int matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;
	
	public Dipendente(int matricola, double stipendio ,double importoOrarioStraordinario, Livello livello,
			Dipartimento dipartimento) {
		
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
		
	}
	
	public Dipendente(int matricola, Dipartimento dipartimento) {
		
		this.matricola = matricola;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
		this.dipartimento = dipartimento;
		
	}

	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	public static double getStipendioBase() {
		return stipendioBase;
	}

	public int getMatricola() {
		return matricola;
	}

	public double getStipendio() {
		return stipendio;
	}

	public Livello getLivello() {
		return livello;
	}
	
	public void stampaDatiDipendente() {
		System.out.println("Ecco i dati del dipendente:");
		System.out.println("Matricola: " + this.matricola + " Livello: " + this.livello + " Dipartimento: " + this.dipartimento + " Stipendio: " + this.stipendio
				+ " Importo Orario Straordinario: " + this.importoOrarioStraordinario);
	}
	
	public void promuovi() {
		if(this.livello == Livello.OPERAIO) {
			this.livello = Livello.IMPIEGATO;
			this.stipendio = stipendioBase * 1.2;
		}
		else if(this.livello == Livello.IMPIEGATO) {
			this.livello = Livello.QUADRO;
			this.stipendio = stipendioBase * 1.5;
		}
		else if(this.livello == Livello.QUADRO) {
			this.livello = Livello.DIRIGENTE;
			this.stipendio = stipendioBase * 2;
		}
		else {
			System.out.println("E quante promozioni vuoi?");
		}
	}
	
	public static double calcolaPaga(Dipendente dipendente) {
		return dipendente.stipendio;
	}
	
	public static double calcolaPagaFinale(Dipendente dipendente, int straordinario) {
		return dipendente.stipendio + (dipendente.importoOrarioStraordinario * straordinario);
	}
}
