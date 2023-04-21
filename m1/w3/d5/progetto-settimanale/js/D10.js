/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Se sei in difficoltà puoi chiedere aiuto a un Teaching Assistant
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per farlo puoi utilizzare il terminale Bash, quello di VSCode o quello del tuo sistema operativo (se utilizzi macOS o Linux)
*/

// JS Basics




//HO COMMENTATO LA MAGGIOR PARTE DEGLI ESERCIZI TRANNE ALCUNI IL CUI RISULTATO O LE ISTRUZIONI ERANO TROPPO OVVIE. SPERO SI CAPISCA TUTTO, E' TUTTO FUNZIONANTE!




/* ESERCIZIO A
  Crea una variabile chiamata "sum" e assegnaci il risultato della somma tra i valori 10 e 20.
*/
{
  let sum = 10 + 20;
  console.log(sum);
}
console.log("===================================");
/* ESERCIZIO B
  Crea una variabile chiamata "random" e assegnaci un numero casuale tra 0 e 20 (deve essere generato dinamicamente a ogni esecuzione).
*/
{
  let random = Math.floor(Math.random() * 21);
  console.log(random);
}
console.log("===================================");
/* ESERCIZIO C
  Crea una variabile chiamata "me" e assegnaci un oggetto contenente le seguenti proprietà: name = il tuo nome, surname = il tuo cognome, age = la tua età.
*/
let me = {
  name: "Manuel",
  surname: "Gadau",
  age: 26
}
console.table(me);
console.log("===================================");
/* ESERCIZIO D
  Crea del codice per rimuovere programmaticamente la proprietà "age" dall'oggetto precedentemente creato.
*/
let programmaticamente = false;
if (programmaticamente == true) {
  delete me.age;
}
console.table(me);
console.log("===================================");
/* ESERCIZIO E
  Crea del codice per aggiungere programmaticamente all'oggetto precedentemente creato un array chiamato "skills", contenente i linguaggi di programmazione che conosci.
*/
let programmaticamente1 = true;
if (programmaticamente1 == true) {
  me.skills = ["HTML", "CSS"];
}
console.table(me);
console.log("===================================");
/* ESERCIZIO F
  Crea un pezzo di codice per aggiungere un nuovo elemento all'array "skills" contenuto nell'oggetto "me".
*/
me.skills.push("JavaScript");
console.table(me);
console.log("===================================");
/* ESERCIZIO G
  Crea un pezzo di codice per rimuovere programmaticamente l'ultimo elemento dall'array "skills" contenuto nell'oggetto "me".
*/
let programmaticamente2 = false;
if (programmaticamente2 == true) {
  me.skills.pop();
}
console.table(me);
console.log("===================================");
// Funzioni

/* ESERCIZIO 1
  Crea una funzione chiamata "dice": deve generare un numero casuale tra 1 e 6.
*/
function dice() {
  let random1_6 = Math.floor(Math.random() * 6) + 1;
  return random1_6;
}
console.log(dice());
console.log("===================================");
/* ESERCIZIO 2
  Crea una funzione chiamata "whoIsBigger" che riceve due numeri come parametri e ritorna il maggiore dei due.
*/
function whoIsBigger(num1, num2) {
  if (num1 > num2) {
    return num1;
  } else if (num1 == num2) {
    return "I numeri sono uguali";
  } else {
    return num2;
  }
}
{
  let num1 = 3, num2 = 4;
  console.log(whoIsBigger(num1, num2));
}
console.log("===================================");
/* ESERCIZIO 3
  Crea una funzione chiamata "splitMe" che riceve una stringa come parametro e ritorna un'array contenente ogni parola della stringa.

  Es.: splitMe("I love coding") => ritorna ["I", "Love", "Coding"]
*/
function splitMe(string) {
  let array = string.split(" ");
  return array;
}
{
  let string = "I love coding";
  console.log(splitMe(string));
}
console.log("===================================");
/* ESERCIZIO 4
  Crea una funzione chiamata "deleteOne" che riceve una stringa e un booleano come parametri.
  Se il valore booleano è true la funzione deve ritornare la stringa senza il primo carattere, altrimenti la deve ritornare senza l'ultimo.
*/
function deleteOne(string, boolean) {
  if (boolean == true) {
    return string.slice(1);
  }
  else {
    return string.slice(0, -1);
  }
}
{
  let boolean = true;
  let string = "Buonasera";
  console.log(deleteOne(string, boolean));
}
console.log("===================================");
/* ESERCIZIO 5
  Crea una funzione chiamata "onlyLetters" che riceve una stringa come parametro e la ritorna eliminando tutte le cifre numeriche.

  Es.: onlyLetters("I have 4 dogs") => ritorna "I have dogs"
*/
function onlyLetters(string) {
  return string.replace(/[0-9]/g, "");    //uso la RegEx /[0-9]/g dove il metodo replace capirà che dovrà sostituire tutti i numeri indicati nelle parentesi. La g sta per global, ovvero tutte le occorrenze di numeri verranno trattati allo stesso modo.
}
{
  let string = "I have 4 dogs";
  console.log(onlyLetters(string));
}
console.log("===================================");
/* ESERCIZIO 6
  Crea una funzione chiamata "isThisAnEmail" che riceve una stringa come parametro e ritorna true se la stringa è un valido indirizzo email.
*/
function isThisAnEmail(string) {
  let regexExp = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/gi; //con questa RegEx si può stabilire se una stringa rientri nei criteri dell'indirizzo mail
  return regexExp.test(string);  //con il metodo test del RegEx verifico effettivamente i criteri
}
{
  let string = "gadaumanuel@gmail.com";
  console.log(isThisAnEmail(string));
}
console.log("===================================");
/* ESERCIZIO 7
  Scrivi una funzione chiamata "whatDayIsIt" che ritorna il giorno della settimana corrente.
*/
function whatDayIsIt() {
  let giornoSettimana = new Date();
  return giornoSettimana.getDay();
}
console.log(whatDayIsIt());  //la funzione restituirà un giorno numerico partendo dal presupposto che lo 0 corrisponde alla domenica e il 6 al sabato
console.log("===================================");
/* ESERCIZIO 8
  Scrivi una funzione chiamata "rollTheDices" che riceve un numero come parametro.
  Deve invocare la precedente funzione dice() il numero di volte specificato nel parametro, e deve tornare un oggetto contenente una proprietà "sum":
  il suo valore deve rappresentare il totale di tutti i valori estratti con le invocazioni di dice().
  L'oggetto ritornato deve anche contenere una proprietà "values", contenente un array con tutti i valori estratti dalle invocazioni di dice().

  Example:
  rollTheDices(3) => ritorna {
      sum: 10
      values: [3, 3, 4]
  }
*/
function rollTheDices(num) {
  let array = [];
  for (let i = 0; i < num; i++) {      //faccio ciclare tante volte quanto il numero inserito come parametro d'ingresso e per ogni ciclo assegno all'array il numero casuale del metodo dice()
    array[i] = dice();
  }
  let somma = array.reduce((p, c) => p + c);  //grazie al metodo degli array reduce() sommo tutti i valori contenuti nell'array
  let oggettoFinale = {
    sum: somma,
    values: array
  }
  return oggettoFinale;
}
{
  let num = 3;
  console.table(rollTheDices(num));
}
console.log("===================================");
/* ESERCIZIO 9
  Scrivi una funzione chiamata "howManyDays" che riceve una data come parametro e ritorna il numero di giorni trascorsi da tale data.
*/
function howManyDays(data) {
  let dataAttuale = new Date();  //creo la variabile con la data attuale
  let milliSecondiTrascorsi = dataAttuale.getTime() - data.getTime();    //calcolo la differenza in millesecondi tra le due date
  let giorniTrascorsi = Math.ceil(milliSecondiTrascorsi / (1000 * 3600 * 24));   //converto i millescondi in giorni effettivi trascorsi
  return giorniTrascorsi;
}
{
  let data = new Date("February 12, 2022");  //imposto una data personalizzata
  console.log("Sono trascorsi " + howManyDays(data) + " giorni");
}
console.log("===================================");
/* ESERCIZIO 10
  Scrivi una funzione chiamata "isTodayMyBirthday" che deve ritornare true se oggi è il tuo compleanno, falso negli altri casi.
*/
function isTodayMyBirthday() {
  let dataAttuale = new Date(), dataCompleanno = new Date("February 12, 1996");  //creo le due date, quella attuale e quella del compleanno
  let giornoAttuale, giornoCompleanno;
  giornoAttuale = dataAttuale.getMonth() + " " + dataAttuale.getDate();    //alla stringa giornoAttuale imposto il mese e il giorno del mese
  giornoCompleanno = dataCompleanno.getMonth() + " " + dataCompleanno.getDate();  //alla stringa giornoCompleanno imposto il mese e il giorno del compleanno
  if (giornoAttuale == giornoCompleanno) {      //paragono le due stringhe
    return "Buon compleanno!";
  }
  else {
    return "Oggi non è il tuo compleanno!";
  }
}
console.log(isTodayMyBirthday());
console.log("===================================");
// Arrays & Oggetti

// NOTA: l'array "movies" usato in alcuni esercizi è definito alla fine di questo file

/* Questo array viene usato per gli esercizi. Non modificarlo. */

const movies = [
  {
    Title: 'The Lord of the Rings: The Fellowship of the Ring',
    Year: '2001',
    imdbID: 'tt0120737',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SX300.jpg',
  },

  {
    Title: 'The Lord of the Rings: The Return of the King',
    Year: '2003',
    imdbID: 'tt0167260',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg',
  },
  {
    Title: 'The Lord of the Rings: The Two Towers',
    Year: '2002',
    imdbID: 'tt0167261',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNGE5MzIyNTAtNWFlMC00NDA2LWJiMjItMjc4Yjg1OWM5NzhhXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg',
  },
  {
    Title: 'Lord of War',
    Year: '2005',
    imdbID: 'tt0399295',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTYzZWE3MDAtZjZkMi00MzhlLTlhZDUtNmI2Zjg3OWVlZWI0XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg',
  },
  {
    Title: 'Lords of Dogtown',
    Year: '2005',
    imdbID: 'tt0355702',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNDBhNGJlOTAtM2ExNi00NmEzLWFmZTQtYTZhYTRlNjJjODhmXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg',
  },
  {
    Title: 'The Lord of the Rings',
    Year: '1978',
    imdbID: 'tt0077869',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BOGMyNWJhZmYtNGQxYi00Y2ZjLWJmNjktNTgzZWJjOTg4YjM3L2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg',
  },
  {
    Title: 'Lord of the Flies',
    Year: '1990',
    imdbID: 'tt0100054',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BOTI2NTQyODk0M15BMl5BanBnXkFtZTcwNTQ3NDk0NA@@._V1_SX300.jpg',
  },
  {
    Title: 'The Lords of Salem',
    Year: '2012',
    imdbID: 'tt1731697',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMjA2NTc5Njc4MV5BMl5BanBnXkFtZTcwNTYzMTcwOQ@@._V1_SX300.jpg',
  },
  {
    Title: 'Greystoke: The Legend of Tarzan, Lord of the Apes',
    Year: '1984',
    imdbID: 'tt0087365',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTM5MzcwOTg4MF5BMl5BanBnXkFtZTgwOTQwMzQxMDE@._V1_SX300.jpg',
  },
  {
    Title: 'Lord of the Flies',
    Year: '1963',
    imdbID: 'tt0057261',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BOGEwYTlhMTgtODBlNC00ZjgzLTk1ZmEtNmNkMTEwYTZiM2Y0XkEyXkFqcGdeQXVyMzU4Nzk4MDI@._V1_SX300.jpg',
  },
  {
    Title: 'The Avengers',
    Year: '2012',
    imdbID: 'tt0848228',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg',
  },
  {
    Title: 'Avengers: Infinity War',
    Year: '2018',
    imdbID: 'tt4154756',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_SX300.jpg',
  },
  {
    Title: 'Avengers: Age of Ultron',
    Year: '2015',
    imdbID: 'tt2395427',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTM4OGJmNWMtOTM4Ni00NTE3LTg3MDItZmQxYjc4N2JhNmUxXkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SX300.jpg',
  },
  {
    Title: 'Avengers: Endgame',
    Year: '2019',
    imdbID: 'tt4154796',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg',
  },
]

/* ESERCIZIO 11
  Scrivi una funzione chiamata "deleteProp" che riceve un oggetto e una stringa come parametri; deve ritornare l'oggetto fornito dopo aver eliminato
  in esso la proprietà chiamata come la stringa passata come secondo parametro.
*/
function deleteProp(oggetto, string) {
  delete oggetto[string];
  return oggetto;
}
{
  let oggetto = {
    nome: "Manuel",
    cognome: "Gadau",
    eta: 26
  }
  let string = "cognome";
  console.log(deleteProp(oggetto, string));
}
console.log("===================================");
/* ESERCIZIO 12
  Scrivi una funzione chiamata "newestMovie" che trova il film più recente nell'array "movies" fornito.
*/
function newestMovie(movies) {
  let annoMaggiore = 0;
  for (let i = 0; i < movies.length; i++) {      //faccio ciclare l'array di oggetti
    if (movies[i].Year > annoMaggiore) {          //se l'anno del film attualmente ciclato è maggiore all'anno più grande trovato allora l'anno più grande sarà pari a tale valore
      annoMaggiore = movies[i].Year;
    }
  }
  for (let i = 0; i < movies.length; i++) {    //faccio ciclare l'array di oggetti per trovare la corrispondenza con l'anno più grande e ritorno il film relativo
    if (movies[i].Year == annoMaggiore) {
      return movies[i];
    }
  }
}
console.table(newestMovie(movies));
console.log("===================================");
/* ESERCIZIO 13
  Scrivi una funzione chiamata countMovies che ritorna il numero di film contenuti nell'array "movies" fornito.
*/
function countMovies(movies) {
  let numeroFilm = movies.length;
  return numeroFilm;
}
console.log("Nell'array movies sono presenti " + countMovies(movies) + " film.");
console.log("===================================");
/* ESERCIZIO 14
  Scrivi una funzione chiamata "onlyTheYears" che crea un array con solamente gli anni di uscita dei film contenuti nell'array "movies" fornito.
*/
function onlyTheYears(movies) {
  let arrayAnni = [];
  for (let film of movies) {
    arrayAnni.push(film.Year);
  }
  return arrayAnni;
}
console.log(onlyTheYears(movies));
console.log("===================================");
/* ESERCIZIO 15
  Scrivi una funzione chiamata "onlyInLastMillennium" che ritorna solamente i film prodotto nel millennio scorso contenuti nell'array "movies" fornito.
*/
function onlyInLastMillennium(movies) {
  let AnniVecchioMillennio = movies.filter(film => film.Year < 2000);  //grazie al metodo filter chiedo ad esso di filtrarmi nel nuovo array solamente i film antecedenti al 2000, ovvero del vecchio millennio
  return AnniVecchioMillennio;
}
console.table(onlyInLastMillennium(movies));
console.log("===================================");
/* ESERCIZIO 16
  Scrivi una funzione chiamata "sumAllTheYears" che ritorna la somma di tutti gli anni in cui sono stati prodotti i film contenuti nell'array "movies" fornito.
*/
function sumAllTheYears(movies) {
  let moviesNumbers = movies.map(film => film.Year = Number(film.Year));  //mappo un nuovo array solamente con gli anni di tutti i film convertiti in numero
  let somma = moviesNumbers.reduce((p, c) => p + c);   //con reduce sommo concatenatamente tutti gli anni
  return somma;
}
console.log("Il totale degli anni sommati è di " + sumAllTheYears(movies) + ".");
console.log("===================================");
/* ESERCIZIO 17
  Scrivi una funzione chiamata "searchByTitle" che riceve una stringa come parametro e ritorna i film nell'array "movies" fornito che la contengono nel titolo.
*/
function searchByTitle(string) {
  let arrayTitles = [];
  for (let film of movies) {  //faccio ciclare i film dell'array movies
    film.Title = film.Title.toLowerCase();   //imposto tutte le lettere del title in minuscolo, per facilitare la ricerca
    if (film.Title.includes(string)) {       //se nel titolo del film corrente è inclusa la stringa indicata allora pusha nel nuovo array il relativo film
      arrayTitles.push(film);
    }
  }
  return arrayTitles;
}
{
  let string = "Lord";
  string = string.toLowerCase();    //per facilitare la ricerca imposto anche la stringa in minuscolo
  console.table(searchByTitle(string));
}
console.log("===================================");
/* ESERCIZIO 18
  Scrivi una funzione chiamata "searchAndDivide" che riceve una stringa come parametro e ritorna un oggetto contenente due array: "match" e "unmatch".
  "match" deve includere tutti i film dell'array "movies" fornito che contengono la stringa fornita all'interno del proprio titolo, mentre "unmatch" deve includere tutti i rimanenti.
*/
//creo una funzione simile a quella precedente per poter verificare i titoli che non includono la stringa indicata
function searchByFalseTitle(string) {
  let arrayTitles = [];
  for (let film of movies) {  //faccio ciclare i film dell'array movies
    film.Title = film.Title.toLowerCase();   //imposto tutte le lettere del title in minuscolo, per facilitare la ricerca
    if (!film.Title.includes(string)) {       //se nel titolo del film corrente NON è inclusa la stringa indicata allora pusha nel nuovo array il relativo film
      arrayTitles.push(film);
    }
  }
  return arrayTitles;
}
////////////////////////////////////////////////////////////////////////////
function searchAndDivide(string) {
  let oggettoMatch = {        //creo il nuovo oggetto
    match: searchByTitle(string),    //richiamo la funzione precedentemente creata per poter inserire tutti i film che includono la stringa nel titolo
    unmatch: searchByFalseTitle(string)    //richiamo la funzione precedentemente creata per poter inserire tutti i film che NON includono la stringa nel titolo
  }
  return oggettoMatch;
}
{
  let string = "lord";
  string = string.toLowerCase();    //per facilitare la ricerca imposto anche la stringa in minuscolo
  console.log(searchAndDivide(string));
}
console.log("===================================");
/* ESERCIZIO 19
  Scrivi una funzione chiamata "removeIndex" che riceve un numero come parametro e ritorna l'array "movies" fornito privo dell'elemento nella posizione ricevuta come parametro.
*/
function removeIndex(num) {
  movies.splice(num, 1);  //grazie al metodo splice elimino un film dall'array movies impostando l'indice con num e decidendo di eliminare un solo film
  return movies;
}
{
  let num = 3;
  console.table(removeIndex(num));
}
console.log("===================================");
// DOM (nota: gli elementi che selezionerai non si trovano realmente nella pagina)

/* ESERCIZIO 20
  Scrivi una funzione per selezionare l'elemento dotato di id "container" all'interno della pagina.
*/
function selezionaContainer() {
  let container = document.querySelector("#container");
  return container;
}
/* ESERCIZIO 21
  Scrivi una funzione per selezionare ogni tag <td> all'interno della pagina.
*/
function selezionaTd() {
  let td = document.querySelectorAll("td");
  return td;
}
/* ESERCIZIO 22
  Scrivi una funzione che, tramite un ciclo, stampa in console il testo contenuto in ogni tag <td> all'interno della pagina.
*/
function stampaTd() {
  let tds = selezionaTd();    //richiamo la funzione selezionaTd che mi assegnerà un array di td alla variabile tds
  for (let td of tds) {
    console.log(td);
  }
}
/* ESERCIZIO 23
  Scrivi una funzione per aggiungere un background di colore rosso a ogni link all'interno della pagina.
*/
function backgroundRed() {
  let links = document.querySelectorAll("a");     //seleziono tutti i link presenti nella pagina e creo un array che li contiene
  for (let link of links) {                       //ciclo l'array e assegno ad ogni link ricorrente un background rosso
    link.style.backgroundColor = "red";
  }
}
/* ESERCIZIO 24
  Scrivi una funzione per aggiungere un nuovo elemento alla lista non ordinata con id "myList".
*/
function aggiungiElemento() {
  let lista = document.querySelector("#myList");       //aggancio la lista con relativo id
  let elemento = document.createElement("li");         //creo l'elemento li
  lista.appendChild(elemento);                         //inserisco l'elemento nella lista padre
}
/* ESERCIZIO 25
  Scrivi una funzione per svuotare la lista non ordinata con id "myList".
*/
function svuotaLista() {
  let lista = document.querySelector("#myList");
  lista.textContent = "";      //svuoto la lista semplicemente inserendo un testo vuoto
}
/* ESERCIZIO 26
  Scrivi una funzione per aggiungere ad ogni tag <tr> la classe CSS "test"
*/
function aggiungiClasse() {
  let trs = document.querySelectorAll("tr");          //aggancio tutti i tr inserendoli in un array
  for (let tr of trs) {                               //ciclo l'array di tr per far in modo che ad ogni tr verrà assegnata la classe "test"
    tr.setAttribute("class", "test");
  }
}
// [EXTRA] JS Avanzato

/* ESERCIZIO 27
  Crea una funzione chiamata "halfTree" che riceve un numero come parametro e costruisce un mezzo albero di "*" (asterischi) dell'altezza fornita.

  Esempio:
  halfTree(3)

  *
  **
  ***

*/
function halfTree(num) {
  string = "*";
  for (let i = 1; i < num + 1; i++) {
    console.log(string.repeat(i));       //la funzione repeat fa si che la stringa di riferimento venga ripetuta n volte
  }
}
{
  let num = 3;
  halfTree(num);
}
console.log("===================================");
/* ESERCIZIO 28
  Crea una funzione chiamata "tree" che riceve un numero come parametro e costruisce un albero di "*" (asterischi) dell'altezza fornita.

  Esempio:
  tree(3)

    *
   ***
  *****

*/
function tree(num) {
  for (let i = 0; i < num; i++) {
    let string = '*';                 //creo la stringa che contiente l'asterisco
    let spazio = ' ';                 //creo la stringa che contiene lo spazio da inserire nella stringa finale

    for (let i2 = 1; i2 <= i; i2++) {        //faccio ciclare un for interno per poter aumentare gradualmente di 2 la stringa degli asterischi
      string = string + '**';
    }

    let spazioPrecedente = spazio.repeat(num - i - 1);     //assegno ad una nuova variabile lo spazio prima creato per poterlo diminuire e aumentare in base alla lunghezza della stringa degli asterischi
    string = spazioPrecedente + string;        //creo la stringa finale che verrà loggata in console
    console.log(string);
  }
}
{
  let num = 7;
  tree(num);
}
console.log("===================================");
/* ESERCIZIO 29
  Crea una funzione chiamata "isItPrime" che riceve un numero come parametro e ritorna true se il numero fornito è un numero primo.
*/
function isItPrime(num) {
  let numeroPrimo = true;     //avvio una variabile di tipo boolean
  // controllo se il numero in questione è maggiore di 1
  if (num > 1) {

    
    for (let i = 2; i < num; i++) {
      if (num % i == 0) {      //verifico se il numero in ingresso sia divisibile per altri numeri oltre che da 1 e da stesso. Nel caso la condizione restituisca 0 allora vorrà dire che non si tratta di un numero primo. 
        numeroPrimo = false;
        break;
      }
    }

    if (numeroPrimo) {
      console.log(num + " è un numero primo");
    } else {
      console.log(num + " non è un numero primo");
    }
  }
}
{
  let num = 5;
  isItPrime(num);
}



