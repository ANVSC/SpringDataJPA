package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    // For updating and deleting data
    @Modifying // Allwoing to modify data inside DB
    @Transactional
    /*
     * @Transactional will create a transaction and make the changes in DB and will commit and ends transction.
     * If there is any exception happens, transaction will gets roll back.
     * Ideally we have to write @Transactional annotation on the top of method in service class
     * For example if there is a method in service is calling 3 different methods in repository layer and lets
      assume those 3 different methods will update 3 different tables. Now we write @Transactional on the method in service.
      This will start a transaction and will update all the 3 tables and will commit transcation at the end.

     */
    @Query(
            nativeQuery = true,
            value = "update tbl_student set first_name = ?1 where email_address = ?2"
    )
    int updateStudentNameByEmailId(String firstName,String emailId);

}

