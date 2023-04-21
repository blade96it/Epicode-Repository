import { Component, OnInit } from '@angular/core';
import { PostsService } from '../../servizi/posts.service';
import { Interfaccia } from 'src/app/interfaccia/interfaccia';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-post-dettaglio',
  templateUrl: './post-dettaglio.component.html',
  styleUrls: ['./post-dettaglio.component.scss']
})
export class PostDettaglioComponent implements OnInit {

  posts!: Interfaccia[];
  id!: number;

  constructor(public servizio: PostsService, private route: ActivatedRoute) { }  //per poter utilizzare il routing params dobbiamo implementare nel costruttore
                                                                                //una route di tipo ActivatedRoute
  ngOnInit(): void {
    this.servizio.getData().subscribe(data => {
      this.posts = data;
    });
    this.id = parseInt(this.route.snapshot.paramMap.get('id')!); //con questo comando affidiamo alla variabile locale id il valore dell'id presente nel url,
  }                                                              //ricavato direttamente dal routing params

}
