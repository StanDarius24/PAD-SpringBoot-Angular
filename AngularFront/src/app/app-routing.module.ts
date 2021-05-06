import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './auth/login/login.component';
import {ChatComponent} from './chat/chat.component';
import {ProfileComponent} from './profile/profile.component';
import { SingupComponent } from './auth/singup/singup.component';
const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'sign-up', component: SingupComponent },
  { path: 'login', component: LoginComponent },
  { path: 'chat', component: ChatComponent},
  { path: 'profile/:name', component: ProfileComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
