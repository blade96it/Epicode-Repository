//seleziono la section con id "to-do-list" e la assegno ad una variabile
let toDoList = document.querySelector("#to-do-list");

//creo la variabile input e ci assegno la creazione di un tag input
let input = document.createElement("input");

//con SetAttribute assegno il tipo di input che dovrà essere creato
input.setAttribute("type", "text");
input.setAttribute("id", "id-input");

//inserisco nella section to-do-list la variabile con l'input creato
toDoList.append(input);

//creo il bottone per poter creare i vari campi della to-do list
let button = document.createElement("button");
button.textContent = "Crea task";

//attivo l'Event Listener al click del bottone
button.addEventListener("click", function () {          //inizio funzione
    let task = document.createElement("div");           //creo uno degli elementi della to-do list (task)
    
    let elimina = document.createElement("button");     //creo il bottone che mi consentirà di eliminare i relativi task
    elimina.textContent = "Elimina task";

    let testo = document.getElementById("id-input").value;  //creo la variabile "testo" che otterrà dal campo input il relativo contenuto
    task.textContent = testo;                               //assegno a task il testo dell'input
    
    toDoList.append(task);                                  //con append immetto il task nella pagina html
    task.appendChild(elimina);                              //con appendChild immetto il bottone elimina relativo al task
    
    //attivo l'Event Listener al click del bottone elimina che rimuoverà sia il bottone che il task associato
    elimina.addEventListener("click", function () {         
        this.remove();
        task.remove();
    })
    
    //creo la variabile "testoCancellato" che otterrà il contenuto del campo input e lo cancellerà
    let testoCancellato = document.getElementById("id-input");
    testoCancellato.value = "";
    
    //avvio un Event Listener per i vari task per poter inserire e disinserire una riga sopra il testo del task
    task.addEventListener("click", function () {
        if (this.style.textDecoration == "line-through") {
            this.style.textDecoration = "none";
        }
        else {
            this.style.textDecoration = "line-through";
        }
    })
});
toDoList.append(button);


