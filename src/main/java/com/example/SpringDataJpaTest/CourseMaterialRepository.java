package com.example.SpringDataJpaTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {


    @Query(
            name = "getAll",
            nativeQuery = true,
            value = "Select * from course_material s"
    )
    public List<CourseMaterial> selectAll();

}
