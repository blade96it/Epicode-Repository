package esercizio2;

import java.util.ArrayList;

public class ThreadClass extends Thread{
	
	private String nome;
	private ArrayList<Integer> subArray;
	private long sommaThread;
	
	public ThreadClass(String nome) {
		this.nome = nome;
	}
	
	public ThreadClass(String nome, ArrayList<Integer> subArray) {
		this.nome = nome;
		this.subArray = subArray;
		this.sommaThread = 0;
	}

	public void sommaValori() {
		for(Integer valore : this.subArray) {
			this.sommaThread+= valore;
		}
	}
	
	public long getSommaThread() {
		return sommaThread;
	}

	@Override
	public void run() {
		sommaValori();
	}
	
}
