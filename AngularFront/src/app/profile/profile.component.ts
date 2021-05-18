import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PostService} from '../shared/post.service';
import {Postmodel} from '../models/postmodel';
import {throwError} from 'rxjs';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthService} from '../auth/shared/auth.service';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {

  /*
       "number": 0,
        "id": 1,
        "name": null,
        "description": null
   */
  commentForm: FormGroup;
  posts: Array<Postmodel> = [] ;
  tatalor : string;
  mail :string;
  constructor(private router: Router,private postService: PostService, private auths: AuthService) {
    this.tatalor = auths.getUserName();
    this.commentForm = new FormGroup({
      text: new FormControl('', Validators.required)
    });

    this.postService.getPostName(this.tatalor).subscribe(
      post =>
      {
        console.log(this.posts);
        this.posts = post;
      }
    )


      console.log(this.posts);

      this.postService.getemail(this.tatalor).subscribe(
        post => {

        }, error => {
          this.mail = error.error.text;

        }
      );


  }

  delete(id:number):void{
    console.log(id);
    this.postService.delete(id);
    this.router.navigateByUrl('/');
  }

  ngOnInit(): void {

  }

}
