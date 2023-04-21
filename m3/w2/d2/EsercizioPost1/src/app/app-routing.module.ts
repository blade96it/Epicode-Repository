import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostAttiviComponent } from './componenti/post-attivi/post-attivi.component';
import { PostNonAttiviComponent } from './componenti/post-non-attivi/post-non-attivi.component';
import { HomepageComponent } from './componenti/homepage/homepage.component';

const routes: Routes = [
  {path: '', component: HomepageComponent},
  {path: 'active-posts', component: PostAttiviComponent},
  {path: 'inactive-posts', component: PostNonAttiviComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
