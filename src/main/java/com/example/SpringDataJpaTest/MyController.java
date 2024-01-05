package com.example.SpringDataJpaTest;


import com.example.Database.DatabaseService;
import com.example.Model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MyController {

    @Autowired
    TestRepo testRepo;
    @Autowired
    CourseServiceClass courseServiceClass;
    @Autowired
    StudentService studentService;
    @Autowired
    DatabaseService service;

    @Autowired
    DatabaseRepo repo;

    @Autowired
    User2NotForUseRepo user2NotForUseRepo;

    @GetMapping("/")
    @PreAuthorize("hasAuthority('COURSE_READ')")
    public List<Course> getCourses(){
        return courseServiceClass.getCourses();
    }

    @PostMapping("/saveCourse")
    @PreAuthorize("hasAuthority('COURSE_WRITE')")
    public void addCourse(@RequestBody Course course){
        courseServiceClass.addCourses(course);
    }

    @PostMapping("/saveStudent")
    @PreAuthorize("hasRole('ADMIN')")
    public void addStudent(@RequestBody Student student){
       studentService.addStudent(student);
    }

    @GetMapping("/getUserByUsername/{username}")
    public NewUsers getUsers(@PathVariable("username") String username){
        return service.getUserByUsername(username);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        service.deleteStudent(id);
        return "Deleted Successfully!";
    }


    @PostMapping("/saveUser")
    public UserModel saveUser(@RequestBody UserModel model){
        return service.saveUser(model);
    }
    @GetMapping("/getUsersNotForUse")
    public List<User2NotForUse> getUsersNotForUse(){
        return user2NotForUseRepo.findAll();
    }

    @PutMapping("/updateStudent/{id}")
    @PreAuthorize("hasAuthority('STUDENT_WRITE')")
    public void updateStudent(@PathVariable("id") Long id, @RequestBody UserModel model){
        service.updateStudent(id, model);
    }

    @GetMapping("/getUserById/{id}")
    public NewUsers getUserById(@PathVariable("id") Long id){
        return service.getUserById(id);
    }




}


