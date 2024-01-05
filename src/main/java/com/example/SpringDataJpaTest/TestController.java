package com.example.SpringDataJpaTest;

import com.example.Database.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tester")
public class TestController {

    @Autowired
    DatabaseRepo service;

    @Autowired
    TestRepo testRepo;


    @GetMapping("/getTests")
    public List<Test> getTests(){
        return testRepo.findAll();
    }

    @GetMapping("/getUsers")
    public List<NewUsers> getUsers(){
        return service.findAll();
    }


}
