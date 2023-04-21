var mirko;
console.log(mirko);
var banana = 1;
console.log(banana);
banana = 2;
console.log(banana);
banana = banana + 2;
console.log(banana);

var cipolla = "rossa";
console.log(cipolla);
cipolla = cipolla + " e verde."
console.log(cipolla);

var boolean = false;
console.log(boolean);

var vettore = [1,"2","cacca",4,5,6,7,8,9];
console.log(vettore);

var pizza = {
    costo: 5,
    gusto: "diavola",
    pizzeria: "da mallena"
}
console.table(pizza);
pizza.costo = 6;
console.table(pizza);

var tastiera = 5;
if(tastiera > 2) {
    console.log("La tastiera ha una valore maggiore di 2");
}
else {
    console.log("La tastiera ha un valore inferiore a 2");
}