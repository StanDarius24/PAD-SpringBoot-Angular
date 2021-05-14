import { Component } from '@angular/core';
import {Message} from '../../models/message';
import {Appdata} from '../../shared/appdata';
import {WebSocketService} from '../../shared/Websocket';
import * as CryptoJS from 'crypto-js';
@Component({
  selector: 'app-stream',
  templateUrl: './stream.component.html',
  styleUrls: ['./stream.component.css']
})

export class StreamComponent {
  message: string = '';
  publishedMessage: Message[] = new Array();
  showTypingIndicator: boolean = false;
  typingUser: string;
  loggedinUserId: number;
  websocket: WebSocket;

  constructor(private appDataService: Appdata,
              private websocketService: WebSocketService) {
    this.websocket = this.websocketService.createNew();
    this.loggedinUserId = this.appDataService.userId;
    this.startListening();
  }

  startListening() {

    this.websocket.onmessage = (event: MessageEvent) => {
      let message: Message = JSON.parse(event.data);
      if (message.type == 'MESSAGE') {

        message.message = CryptoJS.AES.decrypt(message.message,'padproj').toString(CryptoJS.enc.Utf8);

        this.publishedMessage.push(message);
      } else if (message.type == 'TYPING') {
        if (message.from != this.loggedinUserId) {
          this.showUserTypingIndicator(message.fromUserName);
        }
      }
    };
  }

  sendMessage() {
    let msg = this.message;
    if (msg == '' || msg == undefined) return;

    msg = CryptoJS.AES.encrypt(msg,"padproj").toString();


    let message: Message = {
      type: 'MESSAGE',
      from: this.appDataService.userId,
      fromUserName: this.appDataService.userName,
      message: msg
    }
    this.websocket.send(JSON.stringify(message));
    this.message = '';
  }

  sendTypeIndicator() {
    let message: Message = {
      type: 'TYPING',
      from: this.appDataService.userId,
      fromUserName: this.appDataService.userName,
      message: null
    }
    this.websocket.send(JSON.stringify(message));
  }

  showUserTypingIndicator(userName: string) {
    this.typingUser = userName;
    this.showTypingIndicator = true;
    setTimeout(() => {
      this.hideUserTypingIndicator();
    }, 1000);
  }

  hideUserTypingIndicator() {
    if (this.showTypingIndicator) {
      this.showTypingIndicator = false;
    }
  }
}
