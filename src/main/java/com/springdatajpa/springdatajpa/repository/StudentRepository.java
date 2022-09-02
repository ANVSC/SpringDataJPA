package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String str);

    public List<Student> findByGuardianNameContaining(String str);
}

