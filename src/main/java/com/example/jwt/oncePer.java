package com.example.jwt;


import com.example.Database.DatabaseService;
import com.example.Database.UserDetailsImpl;
import com.example.Entity.ApplicationUser;
import com.example.Entity.ApplicationUserDetails;
import com.example.SpringDataJpaTest.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@ComponentScan(basePackages = {"com.example.SpringDataJpaTest", "com.example.Entity"})
public class oncePer extends OncePerRequestFilter {

    private final String jwtSigninKey = "secretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecret";
    private final ApplicationUser app;
    private final JwtUtils jwtUtils;
    private String token;
    private String user;

    @Autowired
    private DatabaseService userDetailsService;

    Claims claims;

    @Autowired
    public oncePer(ApplicationUser app, JwtUtils jwtUtils) {
        this.app = app;
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            String header = request.getHeader("authorization");
//            System.out.println(header);
            if (header == null || !header.startsWith("Bearer")) {
                filterChain.doFilter(request, response);
                return;
            }
            token = header.substring(7);
            user = jwtUtils.extractUsername(token);

            if (user != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails applicationUser = userDetailsService.loadUserByUsername(user);

                if(jwtUtils.isTokenValid(token, applicationUser)) {
                    UsernamePasswordAuthenticationToken us =
                            new UsernamePasswordAuthenticationToken(applicationUser, null,
                                    applicationUser.getAuthorities());
                    us.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(us);
                }
            }

        } catch (UsernameNotFoundException e) {
            throw new RuntimeException(e);
        }

        filterChain.doFilter(request, response);
//        System.out.println(user);
    }

    public void username(){
        System.out.println(jwtUtils.extractUsername(token));
    }

}