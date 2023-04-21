//importo tutti i moduli necessari per il servizio

import { Injectable } from '@angular/core'; //Injectable è utile per far si che il service possa essere "iniettato" nei componenti
import { Interfaccia } from '../interfaccia/interfaccia'; //Interfaccia è stata creata manualmente e servirà a dare una forma specifica agli oggetti
import { HttpClient } from '@angular/common/http';  //HttpClient è utile per poter sfruttare delle chiamate a database locali o online
import { map } from 'rxjs/operators'; //map è utile per poter "mappare" un determinato oggetto e far rispettare determinate condizioni


@Injectable({
  providedIn: 'root'
})
export class PostsService {

  posts!: Interfaccia[];     //creo l'istanza senza assegnazione dell'oggetto posts che seguirà le istruzioni dell'interfaccia importata

  constructor(private http: HttpClient) { }  //all'interno del constructor andrà dichiarata una variabile private di tipo HttpClient che servirà per le call

  getData() {  //con il metodo getData otteniamo i dati dal database e li preperiamo ad essere inseriti in uno specifico array del component
    return this.http.get<Interfaccia[]>('../assets/db.json').pipe(
      map(data => {
        this.posts = data;
        return this.posts;
      })
    );
  }
}
