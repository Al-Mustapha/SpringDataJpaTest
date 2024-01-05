package com.example.SpringDataJpaTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {
@Autowired
CourseRepository courseRepository;

    @Test
    public void getAll(){
        List<Course> course =
                courseRepository.findAll();
        System.out.println(course);
    }

    @Test
    public void addCourse(){
        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("module.abu.edu.ng/SECS303")
                        .build();


        Teacher teacher =
                Teacher.builder()
                        .firstName("Zakkariya")
                        .lastName("Adullahi")
                        .build();

        Course course =
                Course.builder()
                        .title("Computer Science Contents")
                        .unit("3")
                        .courseMaterial(courseMaterial)
                        .teacher(teacher)
                        .build();

        courseRepository.save(course);

    }

    @Test
    public void fetchUsingPagingAndSorting(){

        Pageable pageable = PageRequest.of(0,3);
        List<Course> courses =
                courseRepository.findAll(pageable).getContent();

        Long elements =
                courseRepository.findAll(pageable).getTotalElements();

        System.out.println(courses);
        System.out.println("Total Elements = " +elements);

    }

    @Test
    public void saveStudentsCourses(){

        StudentGuardian studentGuardian =
                StudentGuardian.builder()
                        .guardianPhone("09000")
                        .guardianName("Physics")
                        .guardianEmail("bbbb")
                        .build();
        Student student =
                Student.builder()
                        .studentGuardian(studentGuardian)
                        .name("Bashir")
                        .department("Enginerring")
                        .build();
        Course course =
                Course.builder()
                     //   .student(List.of(student))
                        .unit("9")
                        .title("Wecome")
                        .build();

        courseRepository.save(course);
    }






}