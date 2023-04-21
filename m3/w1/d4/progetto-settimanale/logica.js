var CapiDAbbigliamento = /** @class */ (function () {
    function CapiDAbbigliamento(id, codprod, collezione, capo, modello, quantita, colore, prezzoivaesclusa, prezzoivainclusa, disponibile, saldo) {
        this.id = id;
        this.codprod = codprod;
        this.collezione = collezione;
        this.capo = capo;
        this.modello = modello;
        this.quantita = quantita;
        this.colore = colore;
        this.prezzoivaesclusa = prezzoivaesclusa;
        this.prezzoivainclusa = prezzoivainclusa;
        this.disponibile = disponibile;
        this.saldo = saldo;
    }
    CapiDAbbigliamento.prototype.getSaldoCapo = function () {
        var sconto = (this.prezzoivainclusa * this.saldo) / 100;
        this.prezzoivainclusa = Math.round((this.prezzoivainclusa - sconto) * 100) / 100;
        return this.prezzoivainclusa;
    };
    CapiDAbbigliamento.prototype.getAcquistoCapo = function () {
        console.log("Il prezzo finale del capo è di: " + this.prezzoivainclusa + "€");
        return this.prezzoivainclusa;
    };
    return CapiDAbbigliamento;
}());
//var cardigan = new CapiDAbbigliamento(1, 2121, "primavera", "cardigan", 1231, 5, "nero", 18.5, 22.57, "negozio", 45);

async function fetchAPI() {
    const response = await fetch(`https://mocki.io/v1/765b2daf-41d5-4e94-a0d5-abd918f57b8f`);
    return response.json();
}

fetchAPI().then((array) => {
    for(object of array) {
        var oggetto1 = new CapiDAbbigliamento(object.id, object.codprod, object.collezione, object.capo, object.modello, object.quantita, object.colore, object.prezzoivaesclusa, object.prezzoivainclusa, object.disponibile, object.saldo);
        console.log(oggetto1);
        oggetto1.getSaldoCapo();
        oggetto1.getAcquistoCapo();
    }
});

//mi scuso per non essere andato oltre l'esercizio base. Purtroppo essendo influenzato con febbre non sto riuscendo a ragionare correttamente.
//una volta ripreso ritoccherò sicuramente l'esercizio in queste vacanze, così da fare anche pratica.