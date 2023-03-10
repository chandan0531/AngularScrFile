package com.hostbooks.studentApplication.repository;

import com.hostbooks.studentApplication.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {
    public Course findByCourseName(String cname);
}
