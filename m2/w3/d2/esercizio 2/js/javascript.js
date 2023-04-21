//aggancio gli elementi del DOM
let tabella = document.querySelector("#tabella");
let primo = document.querySelector("#primo");
let precedente = document.querySelector("#precedente");
let successivo = document.querySelector("#successivo");
let ultimo = document.querySelector("#ultimo");

//definisco la classe Paginazione
class Paginazione {
    constructor(items, pageSize) {
        this.items = items;
        this.pageSize = pageSize;
    }
    stampaSuTabella(id, nome, cognome, classe) {
        for (let i = 0; i < this.pageSize; i++) {
            let riga = document.createElement("tr");
            riga.innerHTML = "<td>" + this.items[i].id + "</td>" + "<td>" + this.items[i].nome + "</td>" + "<td>" + this.items[i].cognome + "</td>" + "<td>" + this.items[i].classe + "</td>";
            tabella.appendChild(riga);
        }
        successivo.addEventListener("click", function() {
            
        })
    }
}

//inizializzo l'array che verrà poi utilizzato nell'istanza della classe Paginazione
let array = [
    { id: 1, nome: 'Luca', cognome: 'Rossi', classe: 'A' },
    { id: 2, nome: 'Luigi', cognome: 'Verdi', classe: 'A' },
    { id: 3, nome: 'Mario', cognome: 'Bianchi', classe: 'A' },
    { id: 4, nome: 'Piero', cognome: 'Neri', classe: 'A' },
    { id: 5, nome: 'Paolo', cognome: 'Rossi', classe: 'A' },
    { id: 6, nome: 'Sergio', cognome: 'Verdi', classe: 'A' },
    { id: 7, nome: 'Gianno', cognome: 'Bianchi', classe: 'A' },
    { id: 8, nome: 'Davide', cognome: 'Neri', classe: 'A' },
]

//avvio l'istanza della classe Paginazione
let p = new Paginazione(array, 2);
p.stampaSuTabella();