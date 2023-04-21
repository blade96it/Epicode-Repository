import { Component, OnInit } from '@angular/core';
import { PostsService } from 'src/app/servizi/posts.service';
import { InterfacciaUtenti } from 'src/app/interfaccia/interfaccia-utenti';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-utenti',
  templateUrl: './utenti.component.html',
  styleUrls: ['./utenti.component.scss']
})
export class UtentiComponent implements OnInit {

  utenti!: InterfacciaUtenti[];
  id!: number;
  mostraUtente!: boolean;

  constructor(public servizio: PostsService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.utenti = this.servizio.popolaArray();
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.id = +params.get('id')!
    })
  }
}
