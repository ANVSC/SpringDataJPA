package com.springdatajpa.springdatajpa.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy =  GenerationType.SEQUENCE,
            generator =  "course_material_sequence"
    )
    private Long courseMaterialId;

    private String url;

    @OneToOne(
            cascade= CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name="course_Id",
            referencedColumnName = "courseId" // which column we are referencing in course table
    )
    private Course course;
}
