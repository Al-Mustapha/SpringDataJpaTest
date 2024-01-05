package com.example.Entity;

import com.example.SpringDataJpaTest.Users;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ApplicationUserInterface {
    Optional<ApplicationUserDetails> getUserByUsername(String username);

////    @Query(
////            name = "getQuery",
////            nativeQuery = true,
////            value = "Select * from users where username=:?"
////    )
//
//    @Query("select s from Users s where s.username=:username")
//    Optional<Users> getUsersUsernameAndPassword(String username);
}
