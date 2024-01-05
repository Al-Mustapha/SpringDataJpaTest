package com.example.jwt;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        boolean authenticated = false;
        if(authenticated){
            return new UsernamePasswordAuthenticationToken(username, password, authentication.getAuthorities());
        }
        else {
            throw new AuthenticationException("Invalid username or Password"){};
        }
    }
}
