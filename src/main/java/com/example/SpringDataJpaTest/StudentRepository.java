package com.example.SpringDataJpaTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query("Select s from Student s where s.id=?1")
    Student getStudentFromDatabase();


}
