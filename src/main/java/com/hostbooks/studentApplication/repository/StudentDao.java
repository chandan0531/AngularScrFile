package com.hostbooks.studentApplication.repository;

import com.hostbooks.studentApplication.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {

    public List<Student> findByName(String name);
}
