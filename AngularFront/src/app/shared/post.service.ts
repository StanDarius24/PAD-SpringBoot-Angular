import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Postmodel } from '../models/postmodel';
import { PostCreateModel } from '../models/PostCreateModel';
@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  getAllPosts(): Observable<Array<Postmodel>> {
    return this.http.get<Array<Postmodel>>('http://localhost:8080/SocialMedia/');
  }
  getPost(id: number): Observable<Postmodel> {
    return this.http.get<Postmodel>('http://localhost:8080/SocialMedia/' + id);
  }

  createPost(postPayload: PostCreateModel): Observable<any> {
    console.log(postPayload);
    return this.http.post('http://localhost:8080/SocialMedia/', postPayload);
  }
}
