package com.example.SpringDataJpaTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    MyRepository studentRepository;

    @Autowired
    DatabaseRepo databaseRepo;

    public List<Student> getStudent(String email) {
        return studentRepository.getAllStudents(email);
    }

    public void addStudent(Student student) {
//        Student student = new Student();
//        BeanUtils.copyProperties(studentModel, student);
        studentRepository.save(student);


    }


    public void deleteStudent(Long id) {
        databaseRepo.deleteById(id);
    }

    public List<NewUsers> getUsers() {
        return databaseRepo.findAll();
    }

}
