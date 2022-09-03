package com.springdatajpa.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private  Long courseId;

    private String courseTitle;

    private Integer credit;

    @OneToOne(
            mappedBy = "course" // There is already a object called course in coursematerail class where one-one mapping is done.
    )
    private CourseMaterial courseMaterial;
}
