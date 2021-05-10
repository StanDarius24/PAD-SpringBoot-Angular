import {Handler} from './handler';
import {LoginRequest} from '../models/LoginRequest';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';

@Injectable()
export class Chatservice{
  constructor(private xhrhandler: Handler) {
  }

  userLogin(request: LoginRequest): Observable<any> {
    return this.xhrhandler.doPost('user/login', request);
  }

  listUser(): Observable<any> {
    return this.xhrhandler.doGet('user/list');
  }
}
