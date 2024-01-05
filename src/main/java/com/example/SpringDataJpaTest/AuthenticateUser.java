package com.example.SpringDataJpaTest;

import com.example.Entity.ApplicationUser;
import com.example.jwt.JwtUtils;
import com.example.jwt.Uss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.SpringDataJpaTest.ApplicationUserRole.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@ComponentScan(basePackages = {"com.example.Database"})
public class AuthenticateUser {

    private final JwtUtils jwtUtils;
    private final ApplicationUser applicationUser;
    private final AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jw;

    @Autowired
    TestRepo testRepo;
    private String s;

    @Autowired
    private DatabaseRepo databaseRepo;

    @Autowired
    public AuthenticateUser(JwtUtils jwtUtils, ApplicationUser applicationUser,
                            AuthenticationManager authenticationManager) {
        this.jwtUtils = jwtUtils;
        this.applicationUser = applicationUser;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/authenticate")
    public String authenticateUser(@RequestBody Uss request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        NewUsers users = databaseRepo.fetchByUsername(request.getUsername());

        if(users != null){
            s = jwtUtils.generateToken(users.getUsername());
        }
        else {
            s = "there is an error in your code";
        }
        return s;
    }
    public List<NewUsers> fetchUsers(){
        List<NewUsers> users = databaseRepo.findAll();
        return users;
    }




    }
