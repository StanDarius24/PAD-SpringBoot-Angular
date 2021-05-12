import { Component, OnInit } from '@angular/core';
import {PostService} from '../shared/post.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Postmodel} from '../models/postmodel';
import {Router} from '@angular/router';
import {throwError} from 'rxjs';
import {PostCreateModel} from '../models/PostCreateModel';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {
  date: Date;
  createForm: FormGroup;
  Model: PostCreateModel;
  title = new FormControl('');
  description = new FormControl('');

  constructor(private router: Router, private subredditService: PostService) {
    this.createForm = new FormGroup({
      title: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required)
    });
    this.Model = {
      name: '',
      description: '',
      date: '',
    }
  }

  ngOnInit() {
  }

  discard() {
    this.router.navigateByUrl('/');
  }

  create() {
    this.Model.name = this.createForm.get('title')
      .value;
    this.Model.description = this.createForm.get('description')
      .value;
      this.date = new Date();
      this.Model.date = this.date.toString().substr(0,this.date.toString().indexOf("GMT"));
    console.log(this.Model);
    this.subredditService.createPost(this.Model).subscribe(data => {
      this.router.navigateByUrl('/profile');
    }, error => {
      throwError(error);
    })
  }

}
