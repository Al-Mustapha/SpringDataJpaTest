package com.example.SpringDataJpaTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityTestDAO {
    private String username;
    private String password;

}
