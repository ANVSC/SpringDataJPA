package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entity.Course;
import com.springdatajpa.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial()
    {
        CourseMaterial courseMaterial= CourseMaterial.builder()
                .url("www.spring.com")
                .course(Course.builder().courseTitle("SpringArchitecture").credit(10).build())
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial()
    {
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        courseMaterialList.stream().forEach(System.out::println);

    }

}