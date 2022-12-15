import { Component ,OnInit} from '@angular/core';

import { Student } from '../student';

import {StudentdataService} from '../services/studentdata.service'
import { Router } from '@angular/router';



@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit{


  students:any = Student;


  constructor( private studentS: StudentdataService, private router : Router){  };

  ngOnInit(): void {
    // this.students = [
    //   {"stdId" :1, "firstName" : "chandan", "lastName":"Sharma", "emailId" : "abc@gmail.com"},
    //   {"stdId" :2, "firstName" : "deepak", "lastName":"Sharma", "emailId" : "ac@gmail.com"},
    //   {"stdId" :3, "firstName" : "dee", "lastName":"Sharma", "emailId" : "xyz@gmail.com"},
    //   {"stdId" :4, "firstName" : "cga", "lastName":"Sharma", "emailId" : "pqr@gmail.com"}
    // ];
    this.getStudent();

  }



  getStudent(){
  this.studentS.getstudents().subscribe((data=>{
    this.students = data;
    console.warn(data);

  }))
}

//to update page                                                                                                   
updateStudent(stdId:any){
  console.warn( "hi" ,stdId)
this.router.navigate(['updateStudent',stdId]);
}



//delete by id
deletStudentById(x:any) {
this.studentS.deleteStudent(x).subscribe((data)=>{
  console.warn("delete data: " ,data);
  this.getStudent();
})
window.location.reload();
}


}

