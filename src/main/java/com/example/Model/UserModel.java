package com.example.Model;

import com.example.SpringDataJpaTest.ApplicationUserRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLUpdate;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private Long id;
    private String username;
    private String password;
    private ApplicationUserRole role;

}
