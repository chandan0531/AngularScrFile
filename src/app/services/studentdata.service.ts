import { Injectable } from '@angular/core';


 import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Student } from '../student';
import { observableToBeFn } from 'rxjs/internal/testing/TestScheduler';


@Injectable({
  providedIn: 'root'
})
export class StudentdataService {

private url = "http://localhost:8080/api/students";

private url2 = "http://localhost:8080/api/student";

  constructor(private httpClient : HttpClient) { 
    
  }

  // getstudents(){
  //   return this.httpClient.get(this.url);
  // }

  getstudents():Observable<Student>{

    return this.httpClient.get<Student>(this.url);
  }

///save method
  saveStudent(student : Student): Observable<object>{
    return this.httpClient.post(`${this.url2}`,student);
  }

  

  //getmethod by id
  getStudentById(id:any):Observable<Student>{
    return this.httpClient.get<Student>(`${this.url2}/ ${id}`);
  }

// update method with id
updateStudent(id:any, student:Student):Observable<object>{
  return this.httpClient.put(`${this.url2}/ ${id}`, student);
}
 


// delete method with id
deleteStudent(id:any):Observable<object>{
  return this.httpClient.delete(`${this.url2}/ ${id}`);
}

}
