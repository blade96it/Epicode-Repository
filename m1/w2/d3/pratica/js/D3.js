/* ESERCIZIO 1
 Scrivi un algoritmo per trovare il più grande tra due numeri interi.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let intero1 = 1;
let intero2 = 2;
if(intero1 > intero2) {
  console.log(intero1 + " è il numero più grande.");
}
else {
  console.log(intero2 + " è il numero più grande.");
}
console.log("==========================");
/* ESERCIZIO 2
  Scrivi un algoritmo che mostri "not equal" in console se un numero intero fornito è diverso da 5.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let numeroFornito = 3;
if(numeroFornito != 5) {
  console.log("not equal");
}
console.log("==========================");
/* ESERCIZIO 3
  Scrivi un algoritmo che mostri "divisibile per 5" in console se un numero fornito è perfettamente divisibile per 5 (suggerimento: cerca l'operatore modulo su un motore di ricerca)
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let numeroFornito2 = 10;
let risultato = (numeroFornito2 % 5);
if(risultato == 0) {
  console.log(numeroFornito2 + " è divisibile per 5");
}
console.log("==========================");
/* ESERCIZIO 4
  Scrivi un algoritmo per verificare che, dati due numeri interi, il valore di uno di essi sia 8 oppure se la loro addizione/sottrazione sia uguale a 8.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let intero3 = 8;
let intero4 = 5;
if(intero3 == 8 || intero4 == 8 || intero3 + intero4 == 8 || intero3 - intero4 == 8 || intero4 - intero3 == 8) {
  console.log("8 è il numero");
}
console.log("==========================");
/* ESERCIZIO 5
  Stai lavorando su un sito di e-commerce. Stai salvando il saldo totale del carrello dell'utente in una variabile "totalShoppingCart".
  C'è una promozione in corso: se il totale del carrello supera 50, l'utente ha diritto alla spedizione gratuita (altrimenti la spedizione ha un costo fisso pari a 10).
  Crea un algoritmo che determini l'ammontare totale che deve essere addebitato all'utente per il checkout.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let totalShoppingCart = 60;
let costoSpedizione = 10;
if(totalShoppingCart >= 50) {
  console.log("Hai diritto alla spedizione gratuita, dovrai pagare: " + totalShoppingCart +"€");
}
else {
  console.log("Il totale del checkout è di: " + (totalShoppingCart + costoSpedizione) + "€");
}
console.log("==========================");
/* ESERCIZIO 6
  Stai lavorando su un sito di e-commerce. Oggi è il Black Friday e viene applicato il 20% su ogni prodotto.
  Modifica la risposta precedente includendo questa nuova promozione nell'algoritmo, determinando come prima se le spedizioni sono gratuite oppure no e e calcolando il totale.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
function calcoloPercentuale(totale, percentuale) {
  let sconto = (totale / 100) * percentuale;
  let totaleScontato = totale - sconto;
  return totaleScontato;
}
let sconto = 20;
let prezzoFinale;
if(prezzoFinale = calcoloPercentuale(totalShoppingCart, sconto) >= 50) {
  console.log(" - SCONTO BLACK FRIDAY APPLICATO - Hai diritto alla spedizione gratuita, dovrai pagare: " + (prezzoFinale = calcoloPercentuale(totalShoppingCart, sconto)) +"€");
}
else {
  console.log(" - SCONTO BLACK FRIDAY APPLICATO - Il totale del checkout è di: " + (prezzoFinale = calcoloPercentuale(totalShoppingCart, sconto) + costoSpedizione) +"€");
}
console.log("==========================");
/* ESERCIZIO 7
  Crea tre variabili, e assegna un valore numerico a ciascuna di esse.
  Utilizzando un blocco condizionale, crea un algoritmo per ordinarle secondo il loro valore, dal più alto al più basso.
  Alla fine mostra il risultato in console.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let variabile1 = 2, variabile2 = 5, variabile3 = 3;
if(variabile1 > variabile2 && variabile1 > variabile3) {
  console.log(variabile1);
  if(variabile2 > variabile3) {
    console.log(variabile2);
    console.log(variabile3);
  }
  else {
    console.log(variabile3);
    console.log(variabile2);
  }
}
if(variabile2 > variabile1 && variabile2 > variabile3) {
  console.log(variabile2);
  if(variabile1 > variabile3) {
    console.log(variabile1);
    console.log(variabile3);
  }
  else {
    console.log(variabile3);
    console.log(variabile1);
  }
}
if(variabile3 > variabile1 && variabile3 > variabile2) {
  console.log(variabile3);
  if(variabile1 > variabile2) {
    console.log(variabile1);
    console.log(variabile2);
  }
  else {
    console.log(variabile2);
    console.log(variabile1);
  }
}
console.log("==========================");
/* ESERCIZIO 8
  Crea un algoritmo per verificare che un valore fornito sia un numero oppure no (suggerimento: cerca su un motore di ricerca "typeof").
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let tipo = 23;
if(typeof tipo === "number") {
  console.log("Il valore è un numero");
}
else {
  console.log("Il valore non è un numero");
}
console.log("==========================");
/* ESERCIZIO 9
  Crea un algoritmo per controllare se un numero fornito sia pari o dispari (suggerimento: cerca l'operatore modulo su un motore di ricerca)
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let numero = 4;
let pariODispari = (numero % 2);
if(pariODispari == 0) {
  console.log(numero + " è pari");
}
else {
  console.log(numero + " è dispari");
}
console.log("==========================");
/* ESERCIZIO 10
  Modifica la logica del seguente algoritmo in modo che mostri in console il messaggio corretto in ogni circostanza.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let val = 7
if (val < 10) {
    console.log("Meno di 10");
  } else if (val < 5) {
    console.log("Meno di 5");
  } else {
    console.log("Uguale a 10 o maggiore");
  }
  console.log("==========================");
/* ESERCIZIO 11
  Fornito il seguente oggetto, scrivi del codice per aggiungere una proprietà "city", il cui valore sarà "Toronto".
*/

/* SCRIVI QUI LA TUA RISPOSTA */
const me = {
  name: 'John',
  lastName: 'Doe',
  skills: ['javascript', 'html', 'css'],
  city: 'Toronto'
}
console.log(me);
console.log("==========================");
/* ESERCIZIO 12
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere la proprietà "lastName".
*/

/* SCRIVI QUI LA TUA RISPOSTA */
delete me.lastName;
console.log(me);
console.log("==========================");
/* ESERCIZIO 13
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere l'ultimo elemento della proprietà "skills".
*/

/* SCRIVI QUI LA TUA RISPOSTA */
me.skills.pop();
console.log(me);
console.log("==========================");
/* ESERCIZIO 14
  Scrivi del codice per creare un array inizialmente vuoto. Riempilo successivamente con i numeri da 1 a 10.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let array =[];
for(let i = 0; i < 10; i++) {
  array[i] = i + 1;
}
console.log(array);
console.log("==========================");
/* ESERCIZIO 15
  Scrivi del codice per sostituire l'ultimo elemento dell'array, ovvero il valore 10, con il valore 100.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
array[array.length - 1] = 100;
console.log(array);