import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TodoComponent } from './componenti/todo/todo.component';
import { CompletatiComponent } from './componenti/completati/completati.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoComponent,
    CompletatiComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
