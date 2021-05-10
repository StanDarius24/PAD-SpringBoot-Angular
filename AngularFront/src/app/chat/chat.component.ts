import { Component, OnInit } from '@angular/core';
import {Appdata} from '../shared/appdata';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {



  loggedInUser: String;

  constructor(private appDataService: Appdata) {
    this.loggedInUser = appDataService.userName;
  }



  ngOnInit(): void {
  }


}
