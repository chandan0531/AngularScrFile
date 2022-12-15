import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import {HttpClientModule} from '@angular/common/http';
import { SaveStudentComponent } from './save-student/save-student.component'

import{FormsModule} from '@angular/forms';
import { UpdateStudentComponent } from './update-student/update-student.component'

@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    SaveStudentComponent,
    UpdateStudentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
