import { Component, OnInit } from '@angular/core';
import { PostsService } from '../../servizi/posts.service';
import { Interfaccia } from 'src/app/interfaccia/interfaccia';

@Component({
  selector: 'app-post-attivi',
  templateUrl: './post-attivi.component.html',
  styleUrls: ['./post-attivi.component.scss']
})
export class PostAttiviComponent implements OnInit {

  posts!: Interfaccia[];

  constructor(private servizio: PostsService) { }

  ngOnInit(): void {
    this.servizio.getData().subscribe(data => {
      this.posts = data;
    });

  }

}
