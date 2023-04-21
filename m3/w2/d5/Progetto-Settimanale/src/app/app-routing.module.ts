import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TodoComponent } from './componenti/todo/todo.component';
import { CompletatiComponent } from './componenti/completati/completati.component';

const routes: Routes = [
  { path: 'todo', component: TodoComponent },
  { path: 'completed', component: CompletatiComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
