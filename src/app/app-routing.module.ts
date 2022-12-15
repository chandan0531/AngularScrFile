import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SaveStudentComponent } from './save-student/save-student.component';
import { StudentListComponent } from './student-list/student-list.component';
import { UpdateStudentComponent } from './update-student/update-student.component';

const routes: Routes = [
  {
    path : 'students',
    component : StudentListComponent
  },

  {
    path:'saveStudent',
    component: SaveStudentComponent
  },
  {
    path:'updateStudent/:id',
    component: UpdateStudentComponent
  },
  {
    path:'', 
    redirectTo: 'students',pathMatch:'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
