const btn = document.querySelector("#add");

btn.addEventListener("click", function(event) {
    event.preventDefault();
    //lettura input
    const nome = document.querySelector("#nome").value;
    const cognome = document.querySelector("#cognome").value;
    const dataNascita = document.querySelector("#data_nascita").value;
    //creazione istanza oggetto
    let individuo = new Persona(nome, cognome, dataNascita);
    console.log(individuo.mostraNomeCompleto());
    individuo.aggiungiAllaTabella();
});


//definizione oggetto
function Persona(x,y,z) {
    this.nome = x;
    this.cognome = y;
    this.dataNascita = z;
    this.mostraNomeCompleto = function() {
        return this.nome + " " + this.cognome;
    };
    this.aggiungiAllaTabella = function() {
        const eta = this.calcolaEta();
        let tabella = document.querySelector(".table");
        let tr = document.createElement("tr");
        tr.innerHTML = "<td>" + this.nome + " " + this.cognome + "</td>" + "<td>" + eta + "</td>";
        tabella.appendChild(tr);
    }
    this.calcolaEta = function() {
        const dataCorrente = new Date();
        const annoCorrente = dataCorrente.getFullYear();
        const dataNascita = new Date(this.dataNascita);
        const annoNascita = dataNascita.getFullYear();
        const eta = annoCorrente - annoNascita;
        return eta;
    }

    }