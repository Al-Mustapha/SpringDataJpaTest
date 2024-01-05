package com.example.SpringDataJpaTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


@SpringBootApplication
//@EntityScan(basePackages = {"com.example.Entity"})
@ComponentScans({@ComponentScan("com.example.Repository"), @ComponentScan("com.example.Entity"), @ComponentScan("com.example.Services"), @ComponentScan("com.example.Security")})
public class SpringDataJpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaTestApplication.class, args);
	}

}
