package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entity.Course;
import com.springdatajpa.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher()
    {
        Course courseDSA = Course.builder().courseTitle("DSA").credit(6).build();
        Course courseJava = Course.builder().courseTitle("Java").credit(6).build();
        Teacher teacher = Teacher.builder()
                .firstName("Sumendra")
                .lastName("chowdary")
                .courses(List.of(courseDSA,courseJava))
                .build();
        teacherRepository.save(teacher);
    }
}