//importo tutti i moduli necessari per il servizio

import { Injectable } from '@angular/core'; //Injectable è utile per far si che il service possa essere "iniettato" nei componenti
import { Interfaccia } from '../interfaccia/interfaccia'; //Interfaccia è stata creata manualmente e servirà a dare una forma specifica agli oggetti
import { InterfacciaUtenti } from '../interfaccia/interfaccia-utenti';
import { HttpClient } from '@angular/common/http';  //HttpClient è utile per poter sfruttare delle chiamate a database locali o online
import { map } from 'rxjs/operators'; //map è utile per poter "mappare" un determinato oggetto e far rispettare determinate condizioni
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PostsService {

  posts!: Interfaccia[];     //creo l'istanza senza assegnazione dell'oggetto posts che seguirà le istruzioni dell'interfaccia importata

  utenti!: InterfacciaUtenti [];

  constructor(private http: HttpClient) { }  //all'interno del constructor andrà dichiarata una variabile private di tipo HttpClient che servirà per le call

  getData() {  //con il metodo getData otteniamo i dati dal database e li preperiamo ad essere inseriti in uno specifico array del component
    return this.http.get<Interfaccia[]>('../assets/db.json').pipe(
      map(data => {
        this.posts = data;
        return this.posts;
      })
    );
  }

  popolaArray() {
    return this.utenti = [{id: 1, nome:"Carlo", email:"carlo@gmail.com",ruolo:"amministratore"},
                          {id: 2, nome:"Luca", email:"luca@gmail.com",ruolo:"utente"}]
  }

  aggiornaAttivazione(id: number) {  //in quanto un file json locale non può essere modificato, uso questo metodo per attivare e disattivare momentaneamente i post
    if(this.posts[id - 1].active == true) {
      this.posts[id - 1].active = false;
      console.log(this.posts[id - 1])
    }
    else {
      this.posts[id - 1].active = true
      console.log(this.posts[id - 1])
    }
  }

  sceltaColore(id: number) {   //il metodo seguente controllerà se nel post corrente(nel ciclo for) il type corrisponde ad una determinata categoria.
    let colore = new Array();       //Ad ogni relativo type verrà assegnato il colore. Tutto ciò sarà richiamato nell'html del component attraverso l'ngStyle.
    if (this.posts[id - 1].type == "news") {
      return colore = ["yellow", "black"];
    }
    else if (this.posts[id - 1].type == "politic") {
      return colore = ["black", "white"];
    }
    else {
      return colore = ["blue", "white"];
    }
  }
}
