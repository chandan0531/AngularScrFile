import { Component,OnInit } from '@angular/core';
import { Student } from '../student';
import {StudentdataService} from '../services/studentdata.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-save-student',
  templateUrl: './save-student.component.html',
  styleUrls: ['./save-student.component.css']
})
export class SaveStudentComponent implements OnInit{

student: Student = new Student();

constructor(private studentservice :StudentdataService, private router:Router ){};

  ngOnInit(): void {
    
  }

  //save the student data
//   saveStudents(){
// this.studentservice.saveStudent(this.student).subscribe(data=>{
//   console.warn(data)
//   this.goToStudentList()
// },error=> console.warn(error));

//   }

saveStudents(){
  this.studentservice.saveStudent(this.student).subscribe((data)=>{
    console.warn(data)
  })
  this.goToStudentList()
    }


  goToStudentList(){
    this.router.navigate(['/students']);
  }

  onSubmit(){
    console.warn(this.student)
    this.saveStudents();
  }
}
