var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
//aggancio le variabili presenti nel DOM
var saldoAttualeMadre = document.querySelector("#saldo-madre");
var saldoAttualeFiglio = document.querySelector("#saldo-figlio");
var depositoMadre = document.querySelector("#deposito-madre");
var bottoneDepositaMadre = document.querySelector("#bottone-deposita-madre");
var depositoFiglio = document.querySelector("#deposito-figlio");
var bottoneDepositaFiglio = document.querySelector("#bottone-deposita-figlio");
var prelievoMadre = document.querySelector("#prelievo-madre");
var bottonePrelievoMadre = document.querySelector("#bottone-prelievo-madre");
var prelievoFiglio = document.querySelector("#prelievo-figlio");
var bottonePrelievoFiglio = document.querySelector("#bottone-prelievo-figlio");
var paragrafoInteresse1 = document.querySelector("#interesse1");
var paragrafoInteresse2 = document.querySelector("#interesse2");
var bottoneInteresse = document.querySelector("#bottone-interesse");
var SonAccount = /** @class */ (function () {
    function SonAccount(nome, balanceInit) {
        this.nome = nome;
        this.balanceInit = balanceInit;
    }
    SonAccount.prototype.aggiornaSaldo = function () {
        saldoAttualeFiglio.textContent = "Saldo attuale: " + this.balanceInit + "€";
    };
    SonAccount.prototype.oneDeposit = function (versamento) {
        return this.balanceInit += versamento;
    };
    SonAccount.prototype.oneWithDraw = function (prelievo) {
        return this.balanceInit -= prelievo;
    };
    return SonAccount;
}());
var MotherAccount = /** @class */ (function (_super) {
    __extends(MotherAccount, _super);
    function MotherAccount(nome, balanceInit) {
        return _super.call(this, nome, balanceInit) || this;
    }
    MotherAccount.prototype.aggiornaSaldo = function () {
        saldoAttualeMadre.textContent = "Saldo attuale: " + this.balanceInit + "€";
    };
    MotherAccount.prototype.oneDeposit = function (versamento) {
        return _super.prototype.oneDeposit.call(this, versamento);
    };
    MotherAccount.prototype.oneWithDraw = function (prelievo) {
        return _super.prototype.oneWithDraw.call(this, prelievo);
    };
    MotherAccount.prototype.addInterest = function () {
        var interesse = (this.balanceInit * 10) / 100;
        paragrafoInteresse1.textContent = "L'interesse del 10% maturato è pari a: " + interesse + "€";
        paragrafoInteresse2.textContent = "Il totale è stato aggiunto al bilancio corrente.";
        return this.balanceInit += interesse;
    };
    return MotherAccount;
}(SonAccount));
//creo le istanze delle classi madre e figlio.
var figlio = new SonAccount("Peppino", 500);
var madre = new MotherAccount("Filomena", 1500);
//imposto inizialmente i valori iniziali del saldo.
saldoAttualeMadre.textContent = "Saldo attuale: " + madre.balanceInit + "€";
saldoAttualeFiglio.textContent = "Saldo attuale: " + figlio.balanceInit + "€";
//evento per il bottone deposita della madre, dove verrà aggiunto dinamicamente un deposito e aggiornerà il saldo corrente.
bottoneDepositaMadre.addEventListener("click", function () {
    var depositino = Number(depositoMadre.value);
    madre.oneDeposit(depositino);
    madre.aggiornaSaldo();
    depositoMadre.value = "";
    paragrafoInteresse1.textContent = "";
    paragrafoInteresse2.textContent = "";
});
//evento per il bottone prelievo della madre, dove verrà sottratto dinamicamente un prelievo e aggiornerà il saldo corrente.
bottonePrelievoMadre.addEventListener("click", function () {
    var depositino = Number(prelievoMadre.value);
    madre.oneWithDraw(depositino);
    madre.aggiornaSaldo();
    prelievoMadre.value = "";
    paragrafoInteresse1.textContent = "";
    paragrafoInteresse2.textContent = "";
});
//evento per il bottone deposita del figlio, dove verrà aggiunto dinamicamente un deposito e aggiornerà il saldo corrente.
bottoneDepositaFiglio.addEventListener("click", function () {
    var prelievino = Number(depositoFiglio.value);
    figlio.oneDeposit(prelievino);
    figlio.aggiornaSaldo();
    depositoFiglio.value = "";
    paragrafoInteresse1.textContent = "";
    paragrafoInteresse2.textContent = "";
});
//evento per il bottone prelievo del figlio, dove verrà sottratto dinamicamente un prelievo e aggiornerà il saldo corrente.
bottonePrelievoFiglio.addEventListener("click", function () {
    var prelievino = Number(prelievoFiglio.value);
    figlio.oneWithDraw(prelievino);
    figlio.aggiornaSaldo();
    prelievoFiglio.value = "";
    paragrafoInteresse1.textContent = "";
    paragrafoInteresse2.textContent = "";
});
//evento per il bottone interesse, dove verrà calcolato l'interesse del 10% del saldo attuale e lo aggiornerà gradualmente.
bottoneInteresse.addEventListener("click", function () {
    madre.addInterest();
    madre.aggiornaSaldo();
});
