package com.hostbooks.studentApplication.service;

import com.hostbooks.studentApplication.entities.Student;
import com.hostbooks.studentApplication.exception.CourseException;
import com.hostbooks.studentApplication.exception.StudentException;

import java.util.List;

public interface StudentService {


    public Student saveStudents(Student std)throws StudentException;

    public List<Student> getAllStudent()throws StudentException;

    public Student updateStudentById(Student std ,Integer Id) throws StudentException;

    public String deleteStudentById(Integer Id) throws StudentException;

    public Student registerStudentInCourse(String cname, Student student)throws CourseException;


    public List<Student> findStudentsByName(String name)throws StudentException;

}
