// determino variabili
let boolean = false;
//creo la funzione per poter inserire nel tastierino i relativi input
function inputTastierino(elemento) {
    let input = elemento.getAttribute('data-simbolo');
    document.getElementById('numeri').value += input;
}
//creo la funzione per l'addizione
function inputAddizione(elemento) {
        console.log(document.getElementById('numeri').value.slice(-1));
    if(!document.getElementById('numeri').value.slice(-1) == "+") {
    let input = elemento.getAttribute('data-simbolo');
    document.getElementById('numeri').value += input;
}
}
//creo la funzione per poter calcolare il totale dei numeri inseriti
function tot(){
    let numeri = document.getElementById('numeri');
    numeri.value = eval(numeri.value);
}
//creo la funzione per poter svuotare quanto contenuto nella text-box
function svuota(){
    let numeri = document.getElementById('numeri');
    numeri.value = "";
}
//creo la funzione per calcolare la radice quadrata di un dato numero
function radiceQuadrata(){
    let numeri = document.getElementById('numeri');
    numeri.value = Math.sqrt(numeri.value);
}
//creo la funzione per calcolare il seno di un dato numero
function calcoloSeno(){
    let numeri = document.getElementById('numeri');
    numeri.value = Math.sin(numeri.value);
}
//creo la funzione per calcolare il coseno di un dato numero
function calcoloCoseno(){
    let numeri = document.getElementById('numeri');
    numeri.value = Math.cos(numeri.value);
}
//creo la funzione per calcolare il logaritmo di un dato numero
function calcoloLogaritmo(){
    let numeri = document.getElementById('numeri');
    numeri.value = Math.log(numeri.value);
}
//creo la funzione per calcolare la tangente di un dato numero
function calcoloTangente(){
    let numeri = document.getElementById('numeri');
    numeri.value = Math.tan(numeri.value);
}
//creo la funzione per calcolare il numero elevato alla potenza di num
function calcoloExp(){
    let numeri = document.getElementById('numeri');
    numeri.value = Math.exp(numeri.value);
}
//creo la funzione per calcolare il coseno iperbolico
function calcoloCosenoIperbolico(){
    let numeri = document.getElementById('numeri');
    numeri.value = Math.cosh(numeri.value);
}
//creo la funzione per calcolare il logaritmo10
function calcoloLogaritmo10(){
    let numeri = document.getElementById('numeri');
    numeri.value = Math.log10(numeri.value);
}
//creo la funzione per calcolare la tangente iperbolica di un dato numero
function calcoloTangenteIperbolica(){
    let numeri = document.getElementById('numeri');
    numeri.value = Math.tanh(numeri.value);
}
//creo la funzione per calcolare l'arcoseno di un dato numero
function calcoloArcoseno(){
    let numeri = document.getElementById('numeri');
    numeri.value = Math.asin(numeri.value);
}