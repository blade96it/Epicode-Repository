import { Component, OnInit } from '@angular/core';
import { PostsService } from '../../servizi/posts.service';
import { Interfaccia } from 'src/app/interfaccia/interfaccia';
import { toMaiuscolo } from 'src/app/pipes/toMaiuscolo.pipe';
import { EvidenziatoreDirective } from 'src/app/direttive/evidenziatore.directive';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-post-non-attivi',
  templateUrl: './post-non-attivi.component.html',
  styleUrls: ['./post-non-attivi.component.scss']
})
export class PostNonAttiviComponent implements OnInit {

  posts!: Interfaccia[];

  constructor(public servizio: PostsService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.servizio.getData().subscribe(data => {
      this.posts = data;
    });

  }

}
