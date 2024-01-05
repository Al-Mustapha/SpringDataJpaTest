package com.example.SpringDataJpaTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.SpringDataJpaTest.ApplicationUserRole.ADMIN;
import static com.example.SpringDataJpaTest.ApplicationUserRole.STUDENT;

@Configuration
@EnableWebSecurity
public class PasswordBCrypt {


    @Bean
    public PasswordEncoder passwordEncoder(){
        DelegatingPasswordEncoder del =
                (DelegatingPasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder(10);
        del.setDefaultPasswordEncoderForMatches(bc);
      return del;

    }

//    @Bean
//    public UserDetailsService user(){
//        UserDetails user =
//                User.builder()
//                        .username("Aliyu")
//                        .password(passwordEncoder().encode("Mypassword123"))
////                      .roles(ADMIN.name())
//                        .authorities(ADMIN.getGrantedAuthority())
//                        .build();
//
//        UserDetails student =
//                User.builder()
//                        .username("Musa")
//                        .password(passwordEncoder().encode("Mypassword"))
////                        .roles(STUDENT.name())
//                        .authorities(STUDENT.getGrantedAuthority())
//                        .build();
//        return new InMemoryUserDetailsManager(
//                user,
//                student
//        );
//    }


}
