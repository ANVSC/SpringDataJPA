package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String str);

    public List<Student> findByGuardianNameContaining(String str);

    // JPQL Query - JPQL queries are based on class name not on actual table name
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    // JPQL Query
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentNameByEmailAddress(String emailId);


    // JPQL Query
    @Query("select s.firstName from Student s where s.emailId = :inputEmailId ")
    String getStudentNameByEmailAddress1(String inputEmailId);

}

