import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {PostService} from '../services/post.services';
import {Postmodel} from '../models/postmodel';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  posts: Array<Postmodel> = [] ;

  constructor(private router: Router) {
  }

  gotochat():void
  {
    this.router.navigate(['chat']).then();
  }
  ngOnInit(): void {
  }

  gotoprofil():void
  {
    this.router.navigate(['profile']).then();
  }

}
