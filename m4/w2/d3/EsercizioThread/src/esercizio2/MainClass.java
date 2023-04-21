package esercizio2;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		
		ArrayList<Integer> randomNumbers = new ArrayList<>();
		for(int i = 0; i < 3000; i++) {
			randomNumbers.add((int) Math.floor(Math.random() *(10 - 0 + 1) + 0));
		}
		
		ArrayList<Integer> subArray1 = new ArrayList <Integer>(randomNumbers.subList(0, 999));
		ArrayList<Integer> subArray2 = new ArrayList <Integer>(randomNumbers.subList(1000, 1999));
		ArrayList<Integer> subArray3 = new ArrayList <Integer>(randomNumbers.subList(2000, 2999));
		
		ThreadClass thread1 = new ThreadClass("Thread 1", subArray1);
		ThreadClass thread2 = new ThreadClass("Thread 2", subArray2);
		ThreadClass thread3 = new ThreadClass("Thread 3", subArray3);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread1.join();
		thread2.join();
		thread3.join();
		
		long sommaFinale = thread1.getSommaThread() + thread2.getSommaThread() + thread3.getSommaThread();
		System.out.println("La somma totale è pari a: " + sommaFinale);
	}

}
