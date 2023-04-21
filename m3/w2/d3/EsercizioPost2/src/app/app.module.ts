import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PostAttiviComponent } from './componenti/post-attivi/post-attivi.component';
import { PostNonAttiviComponent } from './componenti/post-non-attivi/post-non-attivi.component';
import { HomepageComponent } from './componenti/homepage/homepage.component';

@NgModule({
  declarations: [
    AppComponent,
    PostAttiviComponent,
    PostNonAttiviComponent,
    HomepageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
