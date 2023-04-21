/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Se sei in difficoltà puoi chiedere aiuto a un Teaching Assistant
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per farlo puoi utilizzare il terminale Bash, quello di VSCode o quello del tuo sistema operativo (se utilizzi macOS o Linux)
*/

/* ESERCIZIO 1
 Scrivi una funzione di nome "area", che riceve due parametri (l1, l2) e calcola l'area del rettangolo associato..
*/

/* SCRIVI QUI LA TUA RISPOSTA */
function calcoloArea(l1, l2) {
    let totale = l1 * l2;
    return totale;
}
{
    let l1 = 5, l2 = 8;
    let area = calcoloArea(l1, l2);
    console.log("L'area del rettangolo è pari a " + area);
    console.log("=======================");
}
/* ESERCIZIO 2
 Scrivi una funzione di nome "crazySum", che riceve due numeri interi come parametri.
 La funzione deve ritornare la somma dei due parametri, ma se il valore dei due parametri è il medesimo deve invece tornare
 la loro somma moltiplicata per tre.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
function crazySum(int1, int2) {
    let totale = int1 + int2;
    if (int1 != int2) {
        return totale;
    }
    else {
        return totale * 3;
    }
}
let int1 = 5, int2 = 4;
let somma = crazySum(int1, int2);
console.log("La somma dei due numeri è pari a " + somma);
console.log("=======================");
/* ESERCIZIO 3
 Scrivi una funzione di nome "crazyDiff" che calcola la differenza assoluta tra un numero fornito come parametro e 19.
 Deve inoltre tornare la differenza assoluta moltiplicata per tre qualora il numero fornito sia maggiore di 19.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
function crazyDiff(l1) {
    let differenza = l1 - 19;
    if (l1 <= 19) {
        return differenza;
    }
    else {
        return differenza * 3;
    }
}
{
    let1 = 18;
    let differenza = crazyDiff(let1);
    console.log(differenza);
}
console.log("=======================");
/* ESERCIZIO 4
 Scrivi una funzione di nome "boundary" che accetta un numero intero n come parametro, e ritorna true se n è compreso tra 20 e 100 (incluso) oppure
 se n è uguale a 400.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
function boundary(n) {
    let boolean;
    if (n >= 20 && n <= 100 || n == 400) {
        return boolean = true;
    }
    else {
        return boolean = false;
    }
}
{
    let n = 400;
    let boolean = boundary(n);
    console.log(boolean);
}
console.log("=======================");
/* ESERCIZIO 5
 Scrivi una funzione di nome "epify" che accetta una stringa come parametro.
 La funzione deve aggiungere la parola "EPICODE" all'inizio della stringa fornita, ma se la stringa fornita comincia già con "EPICODE" allora deve
 ritornare la stringa originale senza alterarla.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
function epify(string) {
    if (string.includes("EPICODE")) {
        return string;
    }
    else {
        string = "EPICODE " + string;
        return string;
    }
}
{
    let string = "è una piattaforma";
    console.log(epify(string));
}
console.log("=======================");
/* ESERCIZIO 6
 Scrivi una funzione di nome "check3and7" che accetta un numero positivo come parametro. La funzione deve controllare che il parametro sia un multiplo
 di 3 o di 7. (Suggerimento: usa l'operatore modulo)
*/

/* SCRIVI QUI LA TUA RISPOSTA */
function check3and7(positivo) {
    if (positivo >= 0) {
        if (positivo % 3 == 0 || positivo % 7 == 0) {
            console.log(positivo + " è un multiplo di 3 o di 7");
        }
        else {
            console.log(positivo + " non è un multiplo di 3 o 7");
        }
    }
    else {
        console.log("SI ACCETTANO SOLO NUMERI POSITIVI");
    }
}
{
    let positivo = 3;
    console.log(check3and7(positivo));
}
console.log("=======================");
/* ESERCIZIO 7
 Scrivi una funzione di nome "reverseString", il cui scopo è invertire una stringa fornita come parametro (es. "EPICODE" --> "EDOCIPE")
*/

/* SCRIVI QUI LA TUA RISPOSTA */
function reverseString(string) {
    let arrayString = string.split("");
    arrayString.reverse();
    string = arrayString.join("");
    return string;
}
{
    let string = "ciao";
    console.log(reverseString(string));
}
console.log("=======================");
/* ESERCIZIO 8
 Scrivi una funzione di nome "upperFirst", che riceve come parametro una stringa formata da diverse parole.
 La funzione deve rendere maiuscola la prima lettera di ogni parola contenuta nella stringa.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
function upperFirst(string) {
    let arrayString = string.split(" ");
    for (let i in arrayString) {
        arrayString[i] = arrayString[i].charAt(0).toUpperCase() + arrayString[i].slice(1);
    }
    string = arrayString.join(" ");
    return string;
}
{
    let string = "ciao che bella la vita";
    console.log(upperFirst(string));
}
console.log("=======================");
/* ESERCIZIO 9
 Scrivi una funzione di nome "cutString", che riceve come parametro una stringa. La funzione deve creare una nuova stringa senza il primo e l'ultimo carattere
 della stringa originale.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
function cutString(string) {
    string = string.slice(1);
    string = string.slice(0, -1);
    return string;
}
{
    let string = "Albano e Romina";
    let stringCutted = cutString(string);
    console.log(stringCutted);
}
console.log("=======================");
/* ESERCIZIO 10
 Scrivi una funzione di nome "giveMeRandom", che accetta come parametro un numero n e ritorna un'array contenente n numeri casuali inclusi tra 0 e 10.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
function giveMeRandom(n) {
    let arrayRandom = new Array(n);
    for(let i = 0; i < arrayRandom.length; i++) {
        arrayRandom[i] = Math.floor(Math.random() * 11);
    }
    return arrayRandom;
}
{
    let n = 5;
    let arrayRandom = giveMeRandom(n);
    console.table(arrayRandom);
}