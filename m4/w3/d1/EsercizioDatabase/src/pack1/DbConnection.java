package pack1;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {

	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "javadb";
	String user = "postgres";
	String pass = "epicode";
	Connection conn;
	Statement st;
	
	public DbConnection() throws SQLException {
		this.conn = DriverManager.getConnection(url+dbName, user, pass);
		this.st = conn.createStatement();
	}
	
	public void creaTabUtenti() throws SQLException {
		String sql = " CREATE TABLE IF NOT EXISTS Utenti ("
                +" id_utente SERIAL PRIMARY KEY,"
                +" nome VARCHAR NOT NULL,"
                +" cognome VARCHAR NOT NULL,"
                +" data_nascita DATE NOT NULL,"
                +" anni INTEGER NOT NULL,"
                +" email VARCHAR NOT NULL UNIQUE"
                +" );";
		this.st.executeUpdate(sql);
	}
	
	public void salvaUtente(Utente u) throws SQLException {
		String sql = "INSERT INTO Utenti (nome, cognome, data_nascita, anni, email)"
                + " VALUES ('" + u.nome + "', '" + u.cognome + "', '" + u.data_nascita+ "',"
                + " " + u.anni + ", '" + u.email+ "')";
		this.st.executeUpdate(sql);
	}
	
	public List<Utente> leggiUtenti() throws SQLException {
		List<Utente> lista = new ArrayList<Utente>();
		String sql = "SELECT * FROM Utenti";
		ResultSet rs = this.st.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt("id_utente");
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			String data_nascita = rs.getString("data_nascita");
			int anni = rs.getInt("anni");
			String email = rs.getString("email");
			Utente u = new Utente (id, nome, cognome, data_nascita, anni, email);
			lista.add(u);
		}
		return lista;
	}
	
	public void modificaUtente(Utente u) throws SQLException {
		String sql = "UPDATE Utenti SET "
                + "nome = '"+u.nome+"', "
                + "cognome = '"+u.cognome+"', "
                + "data_nascita = '"+u.data_nascita+"', "
                + "anni = "+u.anni+", "
                + "email = '"+u.email+"' "
            + "WHERE id_utente = " +u.id_utente;
		this.st.executeUpdate(sql);
	}
	
}
