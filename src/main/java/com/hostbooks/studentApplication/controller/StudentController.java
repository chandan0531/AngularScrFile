package com.hostbooks.studentApplication.controller;

import com.hostbooks.studentApplication.entities.Address;
import com.hostbooks.studentApplication.entities.Student;
import com.hostbooks.studentApplication.service.AddressService;
import com.hostbooks.studentApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("/api/students")
@CrossOrigin("http://localhost:4200/")
public class StudentController {

    @Autowired
    private StudentService sService;



    @PostMapping("api/students")
    ResponseEntity<Student> createStudentController(@Valid @RequestBody Student std){
        Student  stds =  sService.saveStudents(std);
        return new ResponseEntity<>(stds,HttpStatus.CREATED);
    }




    @GetMapping("api/students")
    ResponseEntity<List<Student>> getAllStudentController(){
        List<Student> stds = sService.getAllStudent();

        return new ResponseEntity<List<Student>>(stds,HttpStatus.ACCEPTED);
    }




    @PutMapping("api/students/{Id}")
    ResponseEntity<Student> updateStudentByIdController(@RequestBody Student std ,@PathVariable Integer Id){

        Student stds =  sService.updateStudentById(std, Id);

        return new ResponseEntity<Student>(stds,HttpStatus.ACCEPTED);
    }



    @DeleteMapping("api/students/{Id}")
    ResponseEntity<String> deleteStudentByIdController(@PathVariable Integer Id){


        String message =  sService.deleteStudentById(Id);

        return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
    }


    @GetMapping("api/students/{name}")
    ResponseEntity<List<Student>> getStudentsByNameController(@PathVariable String name){
        List<Student> stds = sService.findStudentsByName(name);

        return new ResponseEntity<List<Student>>(stds,HttpStatus.ACCEPTED);
    }



}
