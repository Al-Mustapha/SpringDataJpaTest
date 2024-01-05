package com.example.SpringDataJpaTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyRepositoryTest2 {
    @Autowired
    MyRepository repository;

    StudentGuardian studentGuardian = StudentGuardian.builder()
            .guardianEmail("guardian@gmail.com")
            .guardianName("Musa")
            .guardianPhone("0999999999")
            .build();

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .department("Physics")
                .name("Mohammed Alhaji Alfa")
                .studentGuardian(studentGuardian)
                .build();
        repository.save(student);

    }

    @Test
    public void findStudentByName(){
        List<Student> stud = repository.findStudentByName("Bashar");
        System.out.println(stud);
    }

    @Test
    public void findStudentEmailByName(){
        Student email = repository.findStudentNameByDepartment("Physics");
        System.out.println(email.getName());

    }

    @Test
    public void fetchAllStudents(){
        List<Student> students = repository.findAll();
        System.out.println(students);

    }

    @Test
    public void fetAllStud(){
        List<Student> student = repository.getAllStudents("guardian@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getName(){
        String getName = repository.getNameByEmail("guardian@gmail.com");
        System.out.println(getName);

    }

    @Test
    public void updateStudentNameByEmail(){
        repository.updateStudentNameByEmail("Ahmad","");
    }



}