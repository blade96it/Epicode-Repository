package esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {

	private String dipendente;
	private int giorniPresenza;
	
	public RegistroPresenze(String dipendente, int giorniPresenza) {
		this.dipendente = dipendente;
		this.giorniPresenza = giorniPresenza;
	}
	
	public static void registraPresenza(String dipendente, int giorni, File file) throws IOException {
		String presenza = "#" + dipendente + "@" + giorni;
		FileUtils.writeStringToFile(file, presenza, "UTF-8", true);
		System.out.println("Scritto sul file!");
	}
	
	public static String leggiPresenzaNome(File file) throws IOException {
		String leggi = FileUtils.readFileToString(file, "UTF-8");
		String array = leggi.substring(leggi.indexOf("#")+1, leggi.indexOf("@"));
		return array;	
	}
}
