package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    // Native SQL Query
    @Query(
            value = "Select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAdressWithNativeSQLQuery(String inputEmialId);

    @Query(
            value = "Select * from tbl_student s where s.email_address = :inputEmialId and s.first_name = :inputfirstname ",
            nativeQuery = true
    )
    Student getStudentByEmailAdressWithNativeSQLQueryAndNamedParam(@Param("inputEmialId") String emialId,
                                                                   @Param("inputfirstname") String firstName
    );

}

