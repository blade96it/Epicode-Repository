// variabili dom
let container = document.getElementById("box_User") as HTMLDivElement;
let btn_ricarica = document.getElementById(
  "bottone-ricarica"
) as HTMLButtonElement;
let inputRicarica = document.getElementById(
  "input_Ricarica"
) as HTMLInputElement;
let cardText1 = document.querySelector(".saldo") as HTMLParagraphElement;
let cardText2 = document.querySelector(".chiamata") as HTMLParagraphElement;
let inputChiamata = document.getElementById("input_chiama") as HTMLInputElement;
let bottoneChiama = document.getElementById(
  "bottone-chiama"
) as HTMLButtonElement;
let bottoneAzzera = document.getElementById(
  "bottone-azzera"
) as HTMLButtonElement;

// interfaccia smartphone
interface ISmartphone {
  carica: number;
  numeroChiamate: number;
}

// classe astratta per smartphone
abstract class Smartphone implements ISmartphone {
  carica: number;
  numeroChiamate: number;
  constructor(carica: number = 0, numeroChiamate: number = 0) {
    this.carica = carica;
    this.numeroChiamate = numeroChiamate;
  }
}

// classe per estender smartphone. firstUser
class FirstUser extends Smartphone {
  constructor(carica: number = 0, numeroChiamate: number = 0) {
    super(carica, numeroChiamate);
  }

  public ricarica(n: number): number {
    return this.carica + n;
  }

  public chiamata(n: number): number {
    let costoMin: number = 0.2;
    this.numeroChiamate++;
    return (this.carica -= n * costoMin);
  }

  public azzeraChiamate(): number {
    return (this.numeroChiamate = 0);
  }

  public getNumeroChiamate(): number {
    cardText2.innerHTML = `Chiamate Effettuate: ${this.numeroChiamate}`;
    return this.numeroChiamate;
  }
}

// creazione istanza del signor eleuterio
let eleuterio = new FirstUser();

// bottone evento al click faccio una ricarica soldi
btn_ricarica.addEventListener("click", function () {
  // allo schiacciare del pulsante, faccio ricarica

  let ricarica = Number(inputRicarica.value);
  eleuterio.carica = eleuterio.ricarica(ricarica);
  cardText1.innerHTML = `Danari Disponbile: ${Number(
    eleuterio.carica.toFixed(2)
  )}£`;
  console.log(eleuterio);
  inputRicarica.value = "";
});

// bottone evento al click aggiungo una chiamata. l'input sono i minuti *0.20 che vengono sotratti a carica
bottoneChiama.addEventListener("click", function () {
  let minutiChiamata = Number(inputChiamata.value);
  eleuterio.chiamata(minutiChiamata);
  cardText1.innerHTML = `Danari Disponbile: ${Number(
    eleuterio.carica.toFixed(2)
  )}£`;
  eleuterio.getNumeroChiamate();
  inputChiamata.value = "";
});

// bottone azzerra le chiamate
bottoneAzzera.addEventListener("click", function () {
  eleuterio.azzeraChiamate();
  eleuterio.getNumeroChiamate();
});

export {};
