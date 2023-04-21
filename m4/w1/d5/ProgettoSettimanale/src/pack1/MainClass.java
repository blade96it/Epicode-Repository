package pack1;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		ElementoMultimediale [] arrayDiElementi = new ElementoMultimediale [5];  //inizializzo un array di ElementoMultimediale che conterrà 5 elementi
		Scanner scannerScelta = new Scanner(System.in);             //avvio i vari scanner che serviranno per le scelte dell'utente
		Scanner scannerScelta2 = new Scanner(System.in);
		Scanner scannerTitolo = new Scanner(System.in);
		Scanner scannerDurata = new Scanner(System.in);
		int check = 0;                 //inizializzo la variabile check per poter controllare se l'utente abbia effettuato tutte e 5 le scelte così che, nel caso in cui--
		//si dovesse uscire dal programma prima di aver effettuato tutte le scelte, il programma si chiuda definitivamente e non richieda ugualmente l'esecuzione
		System.out.println("Benvenuto nel programma di inserimento di elementi multimediali.");
		System.out.println("Dovrai caricare 5 elementi di tre possibili tipi: Audio, Video e Immagine e inserirne i relativi dettagli. Iniziamo!");
		
		for(int i = 0; i < arrayDiElementi.length; i++) {      //ciclo che si ripeterà per 5 volte
			
			int scelta = 0;                 
			String titolo = "";
			int durata = 0;
			System.out.println("Che tipo di elemento vuoi caricare?");
			System.out.println("1. Audio");
			System.out.println("2. Video");
			System.out.println("3. Immagine");
			System.out.println("0. Esci");
			
			scelta = scannerScelta.nextInt();
			
			if(scelta < 4) {    //se la scelta numerica è inferiore a 4, è una scelta giusta e quindi si può proseguire nell'inserimento
			
			switch (scelta) {       //con questo switch scannerizzo le scelte degli utenti e a secondo di essa affido all'array la sottoclasse relativa con parametri inseriti sempre dall'utente
			case 1:
				System.out.println("Inserisci il titolo dell'Audio...");
				titolo = scannerTitolo.nextLine();
				System.out.println("Inserisci la durata dell'Audio...");
				if(scannerDurata.hasNextInt()) {
				durata = scannerDurata.nextInt();
				arrayDiElementi[i] = new Audio(titolo, durata);
				System.out.println("Audio inserito correttamente!");
				check++;
				break;
				}
				else {
					System.out.println("Devi inserire i minuti in numero!!! Riavvia il programma.");
					i = arrayDiElementi.length +1;
					break;
				}
						
			case 2:
				System.out.println("Inserisci il titolo del Video...");
				titolo = scannerTitolo.nextLine();
				System.out.println("Inserisci la durata del Video...");
				if(scannerDurata.hasNextInt()) {
				durata = scannerDurata.nextInt();
				arrayDiElementi[i] = new Video(titolo, durata);
				System.out.println("Video inserito correttamente!");
				check++;
				break;
				}
				else {
					System.out.println("Devi inserire i minuti in numero!!! Riavvia il programma.");
					i = arrayDiElementi.length +1;
					break;
				}
				
			case 3:
				System.out.println("Inserisci il titolo dell'Immagine...");
				titolo = scannerTitolo.nextLine();
				arrayDiElementi[i] = new Immagine(titolo);
				System.out.println("Immagine inserita correttamente!");
				check++;
				break;
				
			case 0:
				System.out.println("Addio...");
				i = arrayDiElementi.length +1;
				break;
			}
			}
			else {       //se la scelta numerica non è corretta allora diminuisco il contatore del ciclo for così da non far proseguire l'inserimento e ripartire da dove ci si era fermati
				System.out.println("Inserisci una scelta numerica corretta!");
				i--;
			}
			
		}
		
		if(check == 5) {           //ecco il check di cui sopra spiegato
		
		System.out.println("Perfetto! Ora potrai scegliere quali elementi da te caricati vorrai eseguire.");
		
		Audio audio;        //dichiaro delle variabili delle sottoclassi
		Video video;
		Immagine immagine;
		int scelta2 = 10;
		while(scelta2 != 0) {  //finchè l'utente non sceglierà l'opzione 0, ovvero l'uscita dal programma, verranno riproposte in loop le scelte
			
			System.out.println("Seleziona l'elemento da eseguire.");
			
			for(int i = 0; i < arrayDiElementi.length; i++) {   //stampo in console tutte le scelte utilizzando il metodo astratto stampa() con parametro in ingresso
				
				if(arrayDiElementi[i] instanceof Audio) {
					audio = (Audio) arrayDiElementi[i];
					audio.stampa(i+1);
				}
				else if(arrayDiElementi[i] instanceof Video) {
					video = (Video) arrayDiElementi[i];
					video.stampa(i+1);
				}
				else {
					immagine = (Immagine) arrayDiElementi[i];
					immagine.stampa(i+1);
				}
				
			}
			System.out.println("0. Esci");
			
			scelta2 = scannerScelta2.nextInt();
			
			switch(scelta2) {    //nello switch verifico che gli elementi contenuti nell'array siano del tipo relativo e li faccio eseguire in console
			//OVVIAMENTE UTILIZZANDO I METODI DI LUMINOSITA' E VOLUME SI POTRA' OTTENERE L'INCREMENTO O IL DECREMENTO DEI RISPETTIVI VALORI.
			//ESSI SONO IMPOSTATI DI DEFAULT A 5
			case 1:
				if(arrayDiElementi[0] instanceof Audio) {
					audio = (Audio) arrayDiElementi[0];
					audio.play();
					break;
				}
				else if(arrayDiElementi[0] instanceof Video) {
					video = (Video) arrayDiElementi[0];
					video.play();
					break;
				}
				else {
					immagine = (Immagine) arrayDiElementi[0];
					immagine.show();
					break;
				}
				
			case 2:
				if(arrayDiElementi[1] instanceof Audio) {
					audio = (Audio) arrayDiElementi[1];
					audio.play();
					break;
				}
				else if(arrayDiElementi[1] instanceof Video) {
					video = (Video) arrayDiElementi[1];
					video.play();
					break;
				}
				else {
					immagine = (Immagine) arrayDiElementi[1];
					immagine.show();
					break;
				}
				
			case 3:
				if(arrayDiElementi[2] instanceof Audio) {
					audio = (Audio) arrayDiElementi[2];
					audio.play();
					break;
				}
				else if(arrayDiElementi[2] instanceof Video) {
					video = (Video) arrayDiElementi[2];
					video.play();
					break;
				}
				else {
					immagine = (Immagine) arrayDiElementi[2];
					immagine.show();
					break;
				}
				
			case 4:
				if(arrayDiElementi[3] instanceof Audio) {
					audio = (Audio) arrayDiElementi[3];
					audio.play();
					break;
				}
				else if(arrayDiElementi[3] instanceof Video) {
					video = (Video) arrayDiElementi[3];
					video.play();
					break;
				}
				else {
					immagine = (Immagine) arrayDiElementi[3];
					immagine.show();
					break;
				}
				
			case 5:
				if(arrayDiElementi[4] instanceof Audio) {
					audio = (Audio) arrayDiElementi[4];
					audio.play();
					break;
				}
				else if(arrayDiElementi[4] instanceof Video) {
					video = (Video) arrayDiElementi[4];
					video.play();
					break;
				}
				else {
					immagine = (Immagine) arrayDiElementi[4];
					immagine.show();
					break;
				}
				
			case 0:
				System.out.println("Addio...");
				break;
			}
			
		}
	}
		
	}
}
