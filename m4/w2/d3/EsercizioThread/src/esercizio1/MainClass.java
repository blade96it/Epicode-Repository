package esercizio1;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		
		ThreadClass thread1 = new ThreadClass("#");
		ThreadClass thread2 = new ThreadClass("*");
		
		thread1.start();
		thread2.start();
		
	}

}
