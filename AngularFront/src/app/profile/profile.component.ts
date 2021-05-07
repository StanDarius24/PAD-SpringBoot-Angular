import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PostService} from '../services/post.services';
import {Postmodel} from '../models/postmodel';
import {throwError} from 'rxjs';
import {FormControl, FormGroup, Validators} from '@angular/forms';

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

  constructor(private router: Router,private postService: PostService) {
    this.commentForm = new FormGroup({
      text: new FormControl('', Validators.required)
    });
    this.postService.getAllPosts().subscribe( post =>
    {
      this.posts = post;
    });
  }

  ngOnInit(): void {

  }




}
