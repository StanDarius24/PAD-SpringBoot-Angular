import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {Chatservice} from '../../shared/chatservice';
import {Appdata} from '../../shared/appdata';
import {AuthService} from '../../auth/shared/auth.service';

@Component({
  selector: 'app-loginchat',
  templateUrl: './loginchat.component.html',
  styleUrls: ['./loginchat.component.css']
})
export class LoginchatComponent  {

  userName: string;
  showErrorMsg: boolean;

  constructor(private router: Router,
              private appService: Chatservice,
              private appDataService: Appdata,
              private authservice:AuthService ) {
    this.userName = authservice.getUserName();

  }

  doLogin() {
    this.appService.userLogin({name: this.userName})
      .subscribe(response => {
        this.appDataService.userId = response.id;
        this.appDataService.userName = response.userName;
        console.log(this.appDataService.userName);
        this.router.navigate(['/chat']);
      });
  }

}
