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

  getPostName(name: string): Observable<Array<Postmodel>>{
    return this.http.get<Array<Postmodel>>('http://localhost:8080/SocialMedia/nrt/' + name);
  }

  createPost(postPayload: PostCreateModel): Observable<any> {
    console.log(postPayload);
    return this.http.post('http://localhost:8080/SocialMedia/', postPayload);
  }

  delete(id: number){
    console.log('Stergere cu http://localhost:8080/SocialMedia/del/' + id);
    return this.http.delete<any>('http://localhost:8080/SocialMedia/del/' +id).subscribe(
      data => { console.log(data)}
    );
  }


  getemail(mail:string): Observable<any> {
    console.log('http://localhost:8080/auth/' + mail);
    return this.http.get('http://localhost:8080/auth/' + mail);
  }
}
