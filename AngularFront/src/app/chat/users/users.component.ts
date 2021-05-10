import {Component, HostListener} from '@angular/core';
import {User} from '../../models/user';
import {Chatservice} from '../../shared/chatservice';
import {Appdata} from '../../shared/appdata';
import {WebSocketService} from '../../shared/Websocket';
import {Message} from '../../models/message';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent  {

  users: User[] = new Array();
  websocket: WebSocket;

  constructor(private appService: Chatservice,
              private appDataService: Appdata,
              private websocketService: WebSocketService) {
    this.websocket = this.websocketService.createNew();
    this.websocket.onopen = (event: MessageEvent) => {
      let message: Message = {
        type: 'JOINED',
        from: this.appDataService.userId,
        fromUserName: this.appDataService.userName,
        message: null
      }
      this.websocket.send(JSON.stringify(message));
    }
    this.initUserList();
    this.startListening();
  }

  startListening() {
    this.websocket.onmessage = (event: MessageEvent) => {
      let message: Message = JSON.parse(event.data);
      if (message.type == 'JOINED') {
        this.setUserStatus(message.from, true);
      } else if (message.type == 'LEFT') {
        this.setUserStatus(message.from, false);
      }
    }
  }

  initUserList() {
    this.appService.listUser().subscribe(response => {
      this.users = response;
      this.setEachUserOnlineOffline();
    });
  }

  setEachUserOnlineOffline() {
    this.users.forEach(user => user.isOnline = false);
  }

  setUserStatus(userId: Number, isOnline: boolean) {
    let user: User = this.users.find(u => u.id == userId);
    user.isOnline = isOnline;
  }

  @HostListener('window:beforeunload')
  close() {
    let message: Message = {
      type: 'LEFT',
      from: this.appDataService.userId,
      fromUserName: this.appDataService.userName,
      message: null
    }
    this.websocket.send(JSON.stringify(message));
  }


}
