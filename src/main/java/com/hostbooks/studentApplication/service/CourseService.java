package com.hostbooks.studentApplication.service;

import com.hostbooks.studentApplication.entities.Course;
import com.hostbooks.studentApplication.exception.CourseException;


public interface CourseService {

    public String saveCourseDetails(Course course, Integer stdId) throws CourseException;
}
