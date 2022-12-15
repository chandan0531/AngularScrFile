package com.hostbooks.studentApplication.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    private Integer courseId;

    @NotNull
    private String courseName;

    @NotNull
    private String description;

    @NotNull
    private String courseType;

    @NotNull
    private Integer duration;

    @NotNull
    private String topics;


    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Student> students = new ArrayList<>();
}
