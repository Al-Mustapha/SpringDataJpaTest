package com.example.SpringDataJpaTest;

import com.example.Database.DatabaseService;
import com.example.Entity.ApplicationUser;
import com.example.jwt.UsernameAndPassword;
import com.example.jwt.oncePer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.example.SpringDataJpaTest","com.example.jwt"})
@EnableMethodSecurity(prePostEnabled = true)
@EnableWebMvc
public class SecurityTestClass {
    private final PasswordEncoder password;
    private final ApplicationUser applicationUser;

    private UsernameAndPassword usernameAndPassword;

    @Autowired
    private DatabaseRepo repo;

    @Autowired
    private DatabaseService databaseService;

    private final oncePer oncePer;
    @Autowired
    public SecurityTestClass(PasswordEncoder password, ApplicationUser applicationUser, com.example.jwt.oncePer oncePer) {
        this.password = password;
        this.applicationUser = applicationUser;
        this.oncePer = oncePer;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authenticationProvider(daoAuthenticationProvider())
                .authorizeHttpRequests()
//                .requestMatchers("/saveStudent").hasRole(ADMIN.name())
                .requestMatchers("/authenticate").permitAll()
                .anyRequest().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
               httpSecurity.addFilterBefore(oncePer, UsernamePasswordAuthenticationFilter.class);
//
//                .formLogin()
//                    .loginPage("/login").permitAll()
//                    .defaultSuccessUrl("/welcome");
//                .and()
//                .rememberMe()
//                    .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))
//                    .key("alwaysrememberme")
//                .and()
//                .logout()
//                    .logoutUrl("/logout")
//                    .clearAuthentication(true)
//                    .invalidateHttpSession(true)
//                    .deleteCookies("JSESSIONID")
//                    .logoutSuccessUrl("/login").permitAll();
        return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsService user(){
//        UserDetails user =
//                User.builder()
//                        .username("Aliyu")
//                        .password(password.encode("Mypassword123"))
////                        .roles(ADMIN.name())
//                        .authorities(ADMIN.getGrantedAuthority())
//                        .build();
//
//        UserDetails student =
//                User.builder()
//                        .username("Musa")
//                        .password(password.encode("Mypassword"))
////                        .roles(STUDENT.name())
//                        .authorities(STUDENT.getGrantedAuthority())
//                        .build();
//        return new InMemoryUserDetailsManager(
//                user,
//                student
//        );
//    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setPasswordEncoder(password);
        dao.setUserDetailsService(databaseService);
        return dao;
    }

    @Bean
    public AuthenticationManager authenticationManager(DatabaseService userDetailsService){
        var authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(databaseService);
        return new ProviderManager(authProvider);
    }

//    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }


//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder(10);
////        return NoOpPasswordEncoder.getInstance();
//    }



}

