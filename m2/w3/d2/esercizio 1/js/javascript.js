//definisco la classe Persona
class Persona {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
    confrontaEta(nameConfronto, ageConfronto) {
        if(this.age > ageConfronto) {
            console.log(this.name + " è più vecchio di " + nameConfronto);
        }
        else if(this.age == ageConfronto) {
            console.log(this.name + " ha la stessa età di " + nameConfronto);
        }
        else {
            console.log(this.name + " è più giovane di " + nameConfronto);
        }
    }
}

//apro le istanze della classe Persona
let p1 = new Persona("Manuel", 26);
let p2 = new Persona("Gabriele", 19);
let p3 = new Persona("Giuseppe", 57);

//utilizzo il metodo confrontaEta della classe Persona
p1.confrontaEta(p2.name, p2.age);
p1.confrontaEta(p3.name, p3.age);