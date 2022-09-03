package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void printCourses()
    {
        List<Course> courses = courseRepository.findAll();
        courses.stream().forEach(System.out::println);
    }

}