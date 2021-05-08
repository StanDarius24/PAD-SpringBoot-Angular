import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {PostService} from '../shared/post.service';
import {Postmodel} from '../models/postmodel';
import {AuthService} from '../auth/shared/auth.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  posts$: Array<Postmodel> = [] ;
  token : string;
  constructor(private router: Router,private postService: PostService, private auth :AuthService) {
    this.postService.getAllPosts().subscribe(post => {
      this.posts$=post;
      console.log(this.posts$);
    })
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
  print():void
  {
    this.token=  this.auth.getJwtToken();
  }

}
