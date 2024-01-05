package com.example.SpringDataJpaTest;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Student_Table",
    uniqueConstraints = @UniqueConstraint(
            name = "constraining",
            columnNames = "Department"
    )
)
public class Student {


    @Id
    @SequenceGenerator(
            name = "my_sequence",
            sequenceName = "my_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "my_sequence"
    )
    private Long id;
    @Column(name = "studname")
    private String name;
    @Column(name = "Department",
            nullable = false,
            unique = true
    )
    private String department;

    @Embedded
    StudentGuardian studentGuardian;
}

