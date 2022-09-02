package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entity.Guardian;
import com.springdatajpa.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void saveStudent()
    {
        /*Student student = Student.builder()
                .emailId("student1@email")
                .firstName("student1FirstName")
                .lastName("student1LastName")
                .gaurdianName("student1GaurdainName")
                .gaurdianMobile("1111111111")
                .gaurdianEmail("gaurdain1@email")
                .build();*/
        Student student = Student.builder()
                .emailId("student2@email")
                .firstName("student2FirstName")
                .lastName("student2LastName")
                //.gaurdianName("student2GaurdainName")
                //.gaurdianMobile("1111111111")
                //.gaurdianEmail("gaurdain2@email")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGaurdian()
    {
        Student student = Student.builder()
                .emailId("chowdary1@email")
                .firstName("Sumendra")
                .lastName("Chowdary")
                .guardian(Guardian.builder().email("SumendraG@email").name("SumendraG").mobile("3333333333").build())
                .build();
        studentRepository.save(student);

    }
    @Test
    public  void getAllStudents()
    {
        List<Student> studentList = studentRepository.findAll();
        studentList.stream().forEach(System.out::println);
    }

    @Test
    public void printStudentsByFirstName()
    {
        List<Student> studentList = studentRepository.findByFirstName("sumendra");
        studentList.stream().forEach(System.out::println);

        List<Student> studentList1 = studentRepository.findByFirstNameContaining("fir");
        studentList1.stream().forEach(System.out::println);

        List<Student> studentList2 = studentRepository.findByGuardianNameContaining("gau");
        studentList2.stream().forEach(System.out::println);



    }

}