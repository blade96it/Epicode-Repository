package pack;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimCard nuovaSim = new SimCard("3385967332");
		nuovaSim.chiama("3465371155", "2:32");
		nuovaSim.stampaSim();
		nuovaSim.ricarica(5);
		nuovaSim.stampaSim();
		nuovaSim.chiama("3493284155", "2:32");
		nuovaSim.chiama("3158465155", "1:00");
		nuovaSim.stampaSim();
	}

}
