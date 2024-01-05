package com.example.SpringDataJpaTest;

import jakarta.persistence.*;

@Entity
public class User2NotForUse {

    @SequenceGenerator(
            name = "myseq",
            sequenceName = "myseq",
            initialValue = 1,
            allocationSize = 1
    )

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "myseq")
    @Id
    private Long id;
    private String username;
    private String password;
}
