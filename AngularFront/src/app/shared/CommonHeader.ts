import { HttpHeaders } from '@angular/common/http';
export class CommonHeader {
  static getCommonHeaders() : HttpHeaders {
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    });
  }
}
