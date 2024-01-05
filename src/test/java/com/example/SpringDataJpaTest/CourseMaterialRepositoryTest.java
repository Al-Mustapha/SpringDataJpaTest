package com.example.SpringDataJpaTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    CourseMaterialRepository repository;


    @Test
    public void persistCourseMaterial(){
        Course course = Course.builder()
                .title("Life no Balanace")
                .unit("6")
                .build();


        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                      //  .course(course)
                        .url("www.lifeotibalance.com")
                        .build();

        repository.save(courseMaterial);


    }

    @Test
    public void fetAll(){
        List<CourseMaterial> courseMaterials =
                repository.findAll();
        System.out.println(courseMaterials);
    }

    @Test
    public void lifeBalance(){
        Teacher teacher =
                Teacher.builder()
                        .lastName("MUSA")
                        .firstName("Jibril")
                        .build();

        Course course =
                Course.builder()
                        .title("ENGINEERING")
                        .unit("10")
                     //   .teacher(teacher)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.musa.com")
                      //  .course(course)
                      //  .teacher(teacher)
                        .build();

    repository.save(courseMaterial);

    }

    @Test
    public void fetching(){
       List<CourseMaterial> cs = repository.selectAll();
        System.out.println(cs);
    }
}