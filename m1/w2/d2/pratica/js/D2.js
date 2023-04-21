/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Se sei in difficoltà puoi chiedere aiuto a un Teaching Assistant
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per farlo puoi utilizzare il terminale Bash, quello di VSCode o quello del tuo sistema operativo (se utilizzi macOS o Linux)
*/

/* ESERCIZIO 1
 Elenca e descrivi i principali datatype in JavaScript. Prova a spiegarli come se volessi farli comprendere a un bambino.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
console.log("Il tipo di datatype 'String' è una variabile che può contenere al suo interno del comune testo o anche dei numeri, che vengono però riconosciuti dal codice come testo (da non confondere con il datatype number).");
console.log("Il tipo di datatype 'Number' è una variabile che può contenere al suo interno dei numeri, che possono essere sia interi che decimali.");
console.log("Il tipo di datatype 'Boolean' è una variabile che può contenere al suo interno esclusivamente due valori che possono essere true(vero) o false(falso). Quando verrà richiesta una determinata condizione ecco che entrerà in gioco questo tipo di variabile, determinando se tale condizione sarà vera, e quindi eseguibile, oppure falsa.")
console.log("Il tipo di datatype 'Array' è una variabile sotto forma di contenitore, il quale potrà avere al suo interno una serie definita o non di valori, solitamente dei numeri. Si potrebbe pensare ad essa come una vera e propria lista di valori.");
console.log("Il tipo di datatype 'Object' è una variabile di tipo oggetto e anch'essa potrebbe essere definita come un contenitore. Essa però è sensibilmente differente dall'array in quanto all'interno di tale oggetto vengono inizializzate determinate proprietà con altrettanti valori, rendendo questo datatype unico nel suo genere. Si potrebbe pensare ad un datatype di tipo oggetto chiamato 'Persona', dove al suo interno si potranno trovare proprietà come: età, sesso, nome ecc...");
console.log("================================");
/* ESERCIZIO 2
 Crea una variable chiamata "name" e assegna ad essa il tuo nome, sotto forma di stringa.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let name = 'Manuel';
console.log("Il mio nome è " + name);
console.log("================================");
/* ESERCIZIO 3
 Scrivi il codice necessario ad effettuare un addizione (una somma) dei numeri 12 e 20.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let somma;
somma = 12 + 20;
console.log("La somma è pari a " + somma);
console.log("================================");
/* ESERCIZIO 4
 Crea una variable di nome "x" e assegna ad essa il numero 12.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let x = 12;
console.log("x è uguale a " + x);
console.log("================================");
/* ESERCIZIO 5
  Riassegna un nuovo valore alla variabile "name" già esistente: il tuo cognome.
  Dimostra l'impossibilità di riassegnare un valore ad una variabile dichiarata con il costrutto const.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
nome = "Gadau";
console.log("Il mio cognome è " + nome);
const nonRiassegnabile = 2;
console.log("Il valore di const è uguale a " + nonRiassegnabile);
// nonRiassegnabile = 3; eliminando questo commento dalla riga il codice andrà in blocco non potendo più leggere quello che avviene dopo, in quanto per l'appunto il const non può essere rivalorizzato.
console.log("================================");
/* ESERCIZIO 6
 Esegui una sottrazione tra i numeri 4 e la variable "x" appena dichiarata (che contiene il numero 12).
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let sottrazione;
sottrazione = x - 4;
console.log("Il valore della sottrazione è uguale a " + sottrazione);
console.log("================================");
/* ESERCIZIO 7
 Crea due variabili: "name1" e "name2". Assegna a name1 la stringa "john", e assegna a name2 la stringa "John" (con la J maiuscola!).
 Verifica che name1 sia diversa da name2 (suggerimento: è la stessa cosa di verificare che la loro uguaglianza sia falsa).
 EXTRA: verifica che la loro uguaglianza diventi true se entrambe vengono trasformate in lowercase (senza cambiare il valore di name2!).
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let name1 = "john";
let name2 = "John";
if (name1 != name2){
  console.log("I due nomi sono diversi");
}
else {
  console.log("I due nomi sono uguali");
}
if (name1 != name2.toLowerCase()){
  console.log("I due nomi sono diversi");
}
else {
  console.log("I due nomi sono uguali");
}
console.log("La varaibile name2, dopo l'if, è comunque rimasta con la lettera maiuscola: " + name2);
