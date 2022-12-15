package com.hostbooks.studentApplication.service;

import com.hostbooks.studentApplication.entities.Course;
import com.hostbooks.studentApplication.entities.Student;
import com.hostbooks.studentApplication.exception.CourseException;
import com.hostbooks.studentApplication.repository.CourseDao;
import com.hostbooks.studentApplication.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao cDao;

    @Autowired
    private StudentDao sDao;

    @Override
    public String saveCourseDetails(Course course, Integer stdId) throws CourseException {
        Optional<Student> optional = sDao.findById(stdId);

        if(optional.isPresent())
        {
            Student std = optional.get();

//            std.getCourses().add(course);
//            course.getStudents().add(std);



//            different way
            List<Course> co = std.getCourses();
            co.add(course);
            std.setCourses(co);

            List<Student> student = course.getStudents();
            student.add(std);
            course.setStudents(student);

            cDao.save(course);
            return "Course added";
        }
        else {
            throw  new CourseException ("Course not added");
        }

    }


}
