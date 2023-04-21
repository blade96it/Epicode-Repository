var giocatore1: number = 23;
var giocatore2: number = 75;

function azzeccaIlNumero(primo, secondo) {
    let numeroCasuale = Math.floor(Math.random() * 101);
    if (primo == numeroCasuale || secondo == numeroCasuale) {
        if (primo == numeroCasuale) {
            console.log("Complimenti! Il Giocatore 1 ha indovinato il numero casuale! Il numero vincente è: " + numeroCasuale);
        }
        else {
            console.log("Complimenti! Il Giocatore 2 ha indovinato il numero casuale! Il numero vincente è: " + numeroCasuale)
        }
    }
    else {
        if (Math.abs(primo - numeroCasuale) < Math.abs(secondo - numeroCasuale)) {  //con Math.abs calcolo la differenza assoluta tra il numero interessato
                                                                                    //e il numero casuale, comparando poi i due risultati.
            console.log("Nessuno dei due ha azzeccato il numero casuale, ma il Giocatore 1 si è avvicinato di più al numero: " + numeroCasuale);
          } else {
            console.log("Nessuno dei due ha azzeccato il numero casuale, ma il Giocatore 2 si è avvicinato di più al numero: " + numeroCasuale);
          }
    }
}