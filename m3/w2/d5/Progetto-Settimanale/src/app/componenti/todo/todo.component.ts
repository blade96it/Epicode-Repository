import { Component, DoCheck, ElementRef, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { TodosService } from 'src/app/servizi/todos.service';
import { InterfacciaTodo } from 'src/app/interfacce/interfaccia-todo';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit, DoCheck{

  todosComponent!: InterfacciaTodo[];
  idCounter: number = 0;
  missingToDo: boolean = false;
  loading: boolean = true;
  @ViewChild('inputToDo') valoreToDo!: ElementRef<HTMLInputElement>//con ViewChild osservo l'html con un riferimento 'inputToDo' e ne creo una variabile
                                                                    //di tipo ElementRef più specificatamente HTMLInputElement.
  constructor(private servizio: TodosService) { }

  ngOnInit(): void {
    setInterval(()=> {
      this.todosComponent = this.servizio.getTodos();
      this.loading = false;
      this.missingToDo = true;}
      ,2000)
    console.log(this.servizio.todos)
  }

  ngDoCheck(): void {
    for(let todo of this.servizio.todos) {
      if(todo.completed == false) {
        this.missingToDo = false; break;
      }
      else {
        this.missingToDo = true;
      }
    }
  }

  aggiungiToDo() {
    this.idCounter++;
    if(this.valoreToDo.nativeElement.value != '')
    this.servizio.addTodos(this.idCounter, this.valoreToDo.nativeElement.value); //aggiungo all'array originale todos (in service) il contenuto dell'input.
    console.log(this.todosComponent)
  }

  checkToDo(index: number) {
    this.servizio.patchTodos(index)
    this.todosComponent = this.servizio.getTodos();
  }
}
