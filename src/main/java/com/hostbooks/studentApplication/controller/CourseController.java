package com.hostbooks.studentApplication.controller;

import com.hostbooks.studentApplication.entities.Course;
import com.hostbooks.studentApplication.entities.Student;
import com.hostbooks.studentApplication.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("api/course/{stdId}")
    ResponseEntity<String> saveStudentController(@RequestBody Course course, @PathVariable Integer stdId){

        String message = courseService.saveCourseDetails(course,stdId);

        return  new ResponseEntity<String>(message, HttpStatus.ACCEPTED);

    }

}
