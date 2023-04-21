import { Component, OnInit } from '@angular/core';
import { PostsService } from '../../servizi/posts.service';
import { Interfaccia } from 'src/app/interfaccia/interfaccia';

@Component({
  selector: 'app-post-non-attivi',
  templateUrl: './post-non-attivi.component.html',
  styleUrls: ['./post-non-attivi.component.scss']
})
export class PostNonAttiviComponent implements OnInit {

  posts!: Interfaccia[];

  constructor(private servizio: PostsService) { }

  ngOnInit(): void {
    this.servizio.getData().subscribe(data => {
      this.posts = data;
    });

  }

}
