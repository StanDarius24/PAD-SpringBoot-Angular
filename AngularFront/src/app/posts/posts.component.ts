import { Component, OnInit } from '@angular/core';
import { PostService } from '../shared/post.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { throwError } from 'rxjs';
import { PostCreateModel } from '../models/PostCreateModel';
import {AuthService} from '../auth/shared/auth.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {
  date: Date;
  path:string;
  url:string;
  createForm: FormGroup;
  Model: PostCreateModel;
  title = new FormControl('');
  description = new FormControl('');
  nameS:string;
  constructor(private router: Router, private subredditService: PostService,private auth:AuthService) {
    this.nameS = auth.getUserName();
    this.createForm = new FormGroup({
      title: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required)
    });
    this.Model = {
      name: '',
      description: '',
      date: '',
      userName:'',
    }
  }

  upload(e) :void {

    this.path = e.target.files[0];
    console.log(this.path);
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
      this.Model.userName = this.nameS;
      this.Model.date = this.date.toString().substr(0,this.date.toString().indexOf("GMT"));
    console.log(this.Model);
    this.subredditService.createPost(this.Model).subscribe(data => {
      this.router.navigateByUrl('/profile');
    }, error => {
      throwError(error);
    })
  }
}
