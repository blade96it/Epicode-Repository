package pack;

public class Cliente {

	int codiceCliente;
	String nomeCognome;
	String email;
	String dataIscrizione;
	static int count = 0;
	
	public Cliente(String nomeCognome, String email, String dataIscrizione) {
		count++;
		this.codiceCliente = count;
		this.nomeCognome = nomeCognome;
		this.email = email;
		this.dataIscrizione = dataIscrizione;
	}
	
	public void stampaCliente() {
		System.out.println("Codice: " + this.codiceCliente + ", Nome e Cognome: " + this.nomeCognome + ", email: " + this.email + ", Data Iscrizione: " + this.dataIscrizione );
	}
}
