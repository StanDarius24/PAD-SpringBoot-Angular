import { Injectable }   from '@angular/core';
import { LocalStorage } from 'ngx-webstorage';
@Injectable()
export class Appdata {
  @LocalStorage()
  public userId: number;

  @LocalStorage()
  public userName: string;

  public clearData(){
    this.userId = null;
    this.userName = null;
  }
}
