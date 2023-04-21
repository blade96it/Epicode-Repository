import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostAttiviComponent } from './componenti/post-attivi/post-attivi.component';
import { PostNonAttiviComponent } from './componenti/post-non-attivi/post-non-attivi.component';
import { HomepageComponent } from './componenti/homepage/homepage.component';
import { PostDettaglioComponent } from './componenti/post-dettaglio/post-dettaglio.component';
import { UtentiComponent } from './componenti/utenti/utenti.component';

const routes: Routes = [
  {path: '', component: HomepageComponent},
  {path: 'active-posts', component: PostAttiviComponent},
  {path: 'active-posts/:id', component: PostDettaglioComponent},
  {path: 'inactive-posts', component: PostNonAttiviComponent},
  {path: 'inactive-posts/:id', component: PostDettaglioComponent},
  {path: 'utenti', component: UtentiComponent},
  {path: 'utenti/:id', component: UtentiComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
