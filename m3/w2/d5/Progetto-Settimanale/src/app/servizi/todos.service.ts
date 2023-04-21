import { Injectable } from '@angular/core';
import { InterfacciaTodo } from '../interfacce/interfaccia-todo';

@Injectable({
  providedIn: 'root'
})
export class TodosService {

  todos: InterfacciaTodo[] = [];   //assegno alla variabile todos l'interfaccia creata appositamente

  constructor() {
  }

  getTodos() {             //metodo che assegnerà l'array todos ad uno specifico array
    return this.todos;
  }

  addTodos(id: number, titolo: string) {
    this.todos.push({ id: id, title: titolo, completed: false })
  }

  patchTodos(index: number) {
    this.todos[index].completed = true;
  }
}
