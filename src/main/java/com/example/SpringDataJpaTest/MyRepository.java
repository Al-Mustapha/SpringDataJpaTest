package com.example.SpringDataJpaTest;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyRepository extends JpaRepository<Student, Long> {

    public List<Student> findStudentByName(String name);
    public Student findStudentNameByDepartment(String department);

    @Query(
            value = "SELECT * from student_table s where s.guardian_email=:email",
            nativeQuery = true
    )
    List<Student> getAllStudents(@Param("email") String email);

    @Query(
            value = "select studname from student_table where guardian_email=?1 ",
            nativeQuery = true
    )
    String getNameByEmail(String email);

    @Modifying
    @Transactional
    @Query(
            value = "update student_table set studname=?1 where guardian_email=?2",
            nativeQuery = true
    )
    int updateStudentNameByEmail(String name,String email);

}
