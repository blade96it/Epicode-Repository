package esercizio1;

public class ThreadClass extends Thread {

	private String message;
	
	public ThreadClass(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		try {
			for(int i = 0; i < 10; i++) {
				System.out.println(this.message);
				Thread.sleep(1000);
			}
		}
		catch (InterruptedException e) {
			System.out.println("Errore nella compilazione del thread");
		}
	}
	
}
