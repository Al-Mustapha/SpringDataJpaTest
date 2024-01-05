package com.example.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages = {"com.example.Entity"})
public class ApplicationUser implements UserDetailsService {

    @Autowired
    private ApplicationUserInterface applicationUserInterface;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserInterface.getUserByUsername(username)
                .orElseThrow(()->
                        new UsernameNotFoundException
                                (String.format("User with username %s not found",username)));
    }





}
