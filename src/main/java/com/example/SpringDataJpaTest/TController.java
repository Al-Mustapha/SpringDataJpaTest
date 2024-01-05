package com.example.SpringDataJpaTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class TController {

    @GetMapping("login")
    public String goLogin(){
        return "login";
    }

    @GetMapping("welcome")
    public String goWelcome(){
        return "welcome";
    }


}
