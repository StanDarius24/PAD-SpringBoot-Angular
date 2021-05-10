import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {AppRoutingModule} from './app-routing.module';

import { ChatComponent } from './chat/chat.component';

import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { NgxWebstorageModule } from 'ngx-webstorage';
import { ToastrModule } from 'ngx-toastr';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { EditorModule } from '@tinymce/tinymce-angular';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './auth/login/login.component';

import { HeaderComponent } from './header/header.component';
import { SingupComponent } from './auth/singup/singup.component';
import { PostsComponent } from './posts/posts.component';
import { StreamComponent } from './chat/stream/stream.component';
import { UsersComponent } from './chat/users/users.component';
import {Appdata} from './shared/appdata';
import {WebSocketService} from './shared/Websocket';
import {Handler} from './shared/handler';
import {Chatservice} from './shared/chatservice';
import { LoginchatComponent } from './chat/loginchat/loginchat.component';
// aici tre sa instalati pachetele pe care le am folosit. O metoda simpla
// e sa cautati exact pe google ce e dupa from
// de exemplu pentru @fortawesome/angular-fontawesome
// https://www.npmjs.com/package/@fortawesome/angular-fontawesome
// deci npm i @fortawesome/angular-fontawesome

// SingupComponent HeaderComponent,     AuthComponent,

@NgModule({
  declarations: [
    AppComponent,
    ChatComponent,
    HomeComponent,
    ProfileComponent,
    LoginComponent,
    HeaderComponent,
    SingupComponent,
    PostsComponent,
    StreamComponent,
    UsersComponent,
    LoginchatComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxWebstorageModule.forRoot(),
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    FontAwesomeModule,
    FormsModule,
    EditorModule,
    NgbModule
  ],
  providers: [Appdata,WebSocketService,Handler,Chatservice],
  bootstrap: [AppComponent]
})
export class AppModule { }
