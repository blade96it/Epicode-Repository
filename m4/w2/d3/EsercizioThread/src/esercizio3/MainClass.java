package esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

public class MainClass {

	public static void main(String[] args) throws IOException {
		
		File file = new File("files/registro.txt");
		//RegistroPresenze.registraPresenza("Manuel Gadau", 5, file);
		//RegistroPresenze.registraPresenza("Gabriele Gadau", 6, file);
		String ciao = RegistroPresenze.leggiPresenzaNome(file);
		System.out.println(ciao);
	}

}
