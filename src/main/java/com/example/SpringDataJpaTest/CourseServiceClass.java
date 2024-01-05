package com.example.SpringDataJpaTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceClass {

    @Autowired
    CourseRepository cs;
    public List<Course> getCourses() {
        return cs.findAll();
    }

    public Course addCourses(Course course){
        course.setTeacher(null);
        course.setCourseMaterial(null);
        return cs.save(course);
    }


}
