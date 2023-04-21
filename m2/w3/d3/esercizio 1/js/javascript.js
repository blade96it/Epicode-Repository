//aggancio il titolo nel DOM
let titolo = document.querySelector("#agganciato");

//avvio il setInterval per contare il tempo
setInterval(() => {
    if (typeof (Storage) != undefined) {
        if (sessionStorage.contatore) {
            sessionStorage.contatore = Number(sessionStorage.contatore) + 1;
        }
        else {
            sessionStorage.contatore = 1;
        }
        titolo.textContent = "E intanto il tempo passa... " + sessionStorage.contatore;
    }
    else {
        titolo.textContent = "Il tuo browser non supporta Web storage...";
    }
}, 1000);
