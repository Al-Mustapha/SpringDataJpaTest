package com.example.Entity;

import com.example.SpringDataJpaTest.ApplicationUserRole;
import com.example.SpringDataJpaTest.Users;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.SpringDataJpaTest.ApplicationUserRole.*;


@Repository("fake")
@ComponentScan(basePackages = {"com.example.SpringDataJpaTest"})
public class ApplicationUserInterfaceImplement implements ApplicationUserInterface{


    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationUserInterfaceImplement(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUserDetails> getUserByUsername(String username) {
        return getUsers().stream()
                .filter(users -> username.equals(users.getUsername()))
                .findFirst();
    }

    public List<ApplicationUserDetails> getUsers(){
        List<ApplicationUserDetails> arrays = Lists.newArrayList(
                new ApplicationUserDetails(
                        STUDENT.getGrantedAuthority(),
                        passwordEncoder.encode("password"),
                        "Aliyu",
                        true,
                        true,
                        true,
                        true),

                new ApplicationUserDetails(
                        ADMIN.getGrantedAuthority(),
                        passwordEncoder.encode("password"),
                        "Musa",
                        true,
                        true,
                        true,
                        true)
        );
     return arrays;
    }
}
