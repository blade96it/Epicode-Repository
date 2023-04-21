package pack;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rettangolo rettangolo1 = new Rettangolo(5, 10);
		Rettangolo rettangolo2 = new Rettangolo(25, 50);
		stampaRettangolo(rettangolo1);
		stampaDueRettangoli(rettangolo1, rettangolo2);
	}

	public static void stampaRettangolo(Rettangolo rettangolo) {
		System.out.println("Il perimetro del rettangolo è pari a: " + rettangolo.calcoloPerimetro());
		System.out.println("L'area del rettangolo è pari a: " + rettangolo.calcoloArea());
	}
	
	public static void stampaDueRettangoli(Rettangolo rettangolo1, Rettangolo rettangolo2) {
		System.out.println("Il perimetro e l'area del primo rettangolo sono rispettivamente pari a: " + rettangolo1.calcoloPerimetro() + " e " + rettangolo1.calcoloArea());
		System.out.println("Il perimetro e l'area del secondo rettangolo sono rispettivamente pari a: " + rettangolo2.calcoloPerimetro() + " e " + rettangolo2.calcoloArea());
		int sommaPerimetri = rettangolo1.calcoloPerimetro() + rettangolo2.calcoloPerimetro();
		int sommaAree = rettangolo1.calcoloArea() + rettangolo2.calcoloArea();
		System.out.println("La somma dei perimetri e delle aree dei rettangoli sono rispettivamente pari a: " + sommaPerimetri + " e " + sommaAree);
	}
}
