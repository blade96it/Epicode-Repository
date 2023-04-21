import { Component, OnInit } from '@angular/core';
import { PostsService } from '../../servizi/posts.service';
import { Interfaccia } from 'src/app/interfaccia/interfaccia';
import { toMaiuscolo } from 'src/app/pipes/toMaiuscolo.pipe';
import { EvidenziatoreDirective } from 'src/app/direttive/evidenziatore.directive';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-post-attivi',
  templateUrl: './post-attivi.component.html',
  styleUrls: ['./post-attivi.component.scss']
})
export class PostAttiviComponent implements OnInit {

  posts!: Interfaccia[];

  constructor(public servizio: PostsService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.servizio.getData().subscribe(data => {
      this.posts = data;
    });
  }

}
