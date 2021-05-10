import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CommonHeader} from './CommonHeader';

const SERVER_BASE_URL = 'http://localhost:8185/';

@Injectable()
export class Handler {

  constructor(private httpClient: HttpClient) {}

  doGet(path : string) {
    return this.httpClient.get(SERVER_BASE_URL + path);
  }

  doPost(path : string, reqData : any) {
    return this.httpClient.post(SERVER_BASE_URL + path, JSON.stringify(reqData), {headers: CommonHeader.getCommonHeaders()});
  }
}
