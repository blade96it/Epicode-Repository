import { Component, OnInit } from '@angular/core';
import { TodosService } from 'src/app/servizi/todos.service';
import { InterfacciaTodo } from 'src/app/interfacce/interfaccia-todo';

@Component({
  selector: 'app-completati',
  templateUrl: './completati.component.html',
  styleUrls: ['./completati.component.scss']
})
export class CompletatiComponent implements OnInit {

  todosComponent!: InterfacciaTodo[];
  loading: boolean = true;

  constructor(private servizio: TodosService) { }

  ngOnInit(): void {
    setInterval(()=> {
      this.todosComponent = this.servizio.getTodos();
      this.loading = false;}
      ,2000)
  }

}
