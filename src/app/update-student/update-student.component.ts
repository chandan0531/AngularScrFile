import { Component,OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentdataService } from '../services/studentdata.service';

import { Student } from '../student';


@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {
  id :any;
  student: Student = new Student();

constructor(private studentService: StudentdataService, private route: ActivatedRoute,
  private router: Router
  ){};

  


  //  to take the data from id with the help of activatedroute
ngOnInit(): void {
  this.id = this.route.snapshot.params['id'];
  this.studentService.getStudentById(this.id).subscribe(data=> {
    this.student = data;
  },
  error=> console.warn(error))
}
  
//update the data with the id 
onSubmit(){

  this.studentService.updateStudent(this.id, this.student).subscribe(data=>{
    this.goToStudentList();
  },error=>console.warn(error))

  
}

goToStudentList(){
  this.router.navigate(['/students']);
}

}
