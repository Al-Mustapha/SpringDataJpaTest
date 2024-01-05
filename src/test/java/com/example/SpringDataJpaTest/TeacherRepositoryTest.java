package com.example.SpringDataJpaTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    TeacherRepository teacherRepository;
    @Test
    public void addTeacher(){

        Course course = Course.builder()
                .unit("6")
                .title("Engineering")
                .build();

        Course course1 = Course.builder()
                .unit("6")
                .title("Physics")
                .build();

        Teacher teacher = Teacher.builder()
                .teacherId(3L)
                .firstName("Musa")
                .lastName("Musantor")
          //      .course(List.of(course,course1))
                .build();

        teacherRepository.save(teacher);

    }



}