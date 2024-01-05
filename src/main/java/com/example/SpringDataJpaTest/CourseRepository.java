package com.example.SpringDataJpaTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(
            name = "getCourses",
            nativeQuery = true,
            value = "Select * from course"
    )
    public List<Course> getAllCourses();
}
