//aggancio le variabili presenti nel DOM
var saldoAttualeMadre = document.querySelector("#saldo-madre") as HTMLHeadingElement;
var saldoAttualeFiglio = document.querySelector("#saldo-figlio") as HTMLHeadingElement;

var depositoMadre = document.querySelector("#deposito-madre") as HTMLInputElement;
var bottoneDepositaMadre = document.querySelector("#bottone-deposita-madre") as HTMLButtonElement;
var depositoFiglio = document.querySelector("#deposito-figlio") as HTMLInputElement;
var bottoneDepositaFiglio = document.querySelector("#bottone-deposita-figlio") as HTMLButtonElement;

var prelievoMadre = document.querySelector("#prelievo-madre") as HTMLInputElement;
var bottonePrelievoMadre = document.querySelector("#bottone-prelievo-madre") as HTMLButtonElement;
var prelievoFiglio = document.querySelector("#prelievo-figlio") as HTMLInputElement;
var bottonePrelievoFiglio = document.querySelector("#bottone-prelievo-figlio") as HTMLButtonElement;

var paragrafoInteresse1 = document.querySelector("#interesse1") as HTMLParagraphElement;
var paragrafoInteresse2 = document.querySelector("#interesse2") as HTMLParagraphElement;
var bottoneInteresse = document.querySelector("#bottone-interesse") as HTMLButtonElement;

class SonAccount {
    nome: string;
    balanceInit: number;

    constructor(nome: string, balanceInit: number) {
        this.nome = nome;
        this.balanceInit = balanceInit;
    }
    aggiornaSaldo() {
        saldoAttualeFiglio.textContent = "Saldo attuale: " + this.balanceInit + "€";
    }
    oneDeposit(versamento: number): number {
        return this.balanceInit += versamento;
    }
    oneWithDraw(prelievo: number): number {
        return this.balanceInit -= prelievo;
    }
}

class MotherAccount extends SonAccount {
    constructor(nome: string, balanceInit: number) {
        super(nome, balanceInit);
    }
    aggiornaSaldo() {
        saldoAttualeMadre.textContent = "Saldo attuale: " + this.balanceInit + "€";
    }
    oneDeposit(versamento: number): number {
        return super.oneDeposit(versamento);
    }
    oneWithDraw(prelievo: number): number {
        return super.oneWithDraw(prelievo);
    }
    addInterest(): number {
        var interesse: number = (this.balanceInit * 10) / 100;
        paragrafoInteresse1.textContent = "L'interesse del 10% maturato è pari a: " + interesse + "€";
        paragrafoInteresse2.textContent = "Il totale è stato aggiunto al bilancio corrente.";
        return this.balanceInit += interesse;
    }
}

//creo le istanze delle classi madre e figlio.
var figlio = new SonAccount("Peppino", 500);
var madre = new MotherAccount("Filomena", 1500);

//imposto i valori iniziali del saldo.
saldoAttualeMadre.textContent = "Saldo attuale: " + madre.balanceInit + "€";
saldoAttualeFiglio.textContent = "Saldo attuale: " + figlio.balanceInit + "€";

//evento per il bottone deposita della madre, dove verrà aggiunto dinamicamente un deposito e aggiornerà il saldo corrente.
bottoneDepositaMadre.addEventListener("click", function () {
    const depositino = Number(depositoMadre.value);
    madre.oneDeposit(depositino);
    madre.aggiornaSaldo();
    depositoMadre.value = "";
    paragrafoInteresse1.textContent = "";
    paragrafoInteresse2.textContent = "";
})

//evento per il bottone prelievo della madre, dove verrà sottratto dinamicamente un prelievo e aggiornerà il saldo corrente.
bottonePrelievoMadre.addEventListener("click", function () {
    const depositino = Number(prelievoMadre.value);
    madre.oneWithDraw(depositino);
    madre.aggiornaSaldo();
    prelievoMadre.value = "";
    paragrafoInteresse1.textContent = "";
    paragrafoInteresse2.textContent = "";
})

//evento per il bottone deposita del figlio, dove verrà aggiunto dinamicamente un deposito e aggiornerà il saldo corrente.
bottoneDepositaFiglio.addEventListener("click", function () {
    const prelievino = Number(depositoFiglio.value);
    figlio.oneDeposit(prelievino);
    figlio.aggiornaSaldo();
    depositoFiglio.value = "";
    paragrafoInteresse1.textContent = "";
    paragrafoInteresse2.textContent = "";
})

//evento per il bottone prelievo del figlio, dove verrà sottratto dinamicamente un prelievo e aggiornerà il saldo corrente.
bottonePrelievoFiglio.addEventListener("click", function () {
    const prelievino = Number(prelievoFiglio.value);
    figlio.oneWithDraw(prelievino);
    figlio.aggiornaSaldo();
    prelievoFiglio.value = "";
    paragrafoInteresse1.textContent = "";
    paragrafoInteresse2.textContent = "";
})

//evento per il bottone interesse, dove verrà calcolato l'interesse del 10% del saldo attuale e lo aggiornerà gradualmente.
bottoneInteresse.addEventListener("click", function() {
    madre.addInterest();
    madre.aggiornaSaldo();
})