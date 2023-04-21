package pack1;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String stringa = "banana";
		System.out.println(stringaPariDispari(stringa));
		
		int anno = 2012;
		System.out.println(annoBisestile(anno));
	}

	public static boolean stringaPariDispari(String stringa) {
		int lunghezza = stringa.length();
		if((lunghezza % 2) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean annoBisestile(int anno) {
		if((anno % 4) == 0) {
			return true;
		}
		else if ((anno % 100) == 0 && (anno % 400) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
