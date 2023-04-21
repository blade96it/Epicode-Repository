//aggancio le variabili nel DOM
let titoloCard = document.querySelectorAll(".card-title");
let mailCard = document.querySelectorAll(".card-link");
let imgCard = document.querySelectorAll(".image");

fetch('./json/users.json')            //con fetch mi collego al file JSON locale (in questo caso, in quanto si tratta di un file locale, con LiveServer sarà possibile visionarlo)
  .then(response => response.json())  
  .then(data => { const arrayDiJson = data; //con questo then affido il data (ovvero in questo caso l'array di oggetti contenuto nel file) ad una variabile da me creata
    for(let i = 0; i < arrayDiJson.length; i++) {  //faccio ciclare un semplice for con un contatore comune da utilizzare per fare girare tutti gli array del DOM creati prima nella dichiarazione
        imgCard[i].src = arrayDiJson[i].profileURL; 
        titoloCard[i].textContent = arrayDiJson[i].firstName + " " + arrayDiJson[i].lastName;
        mailCard[i].textContent = arrayDiJson[i].email;
    }
  });