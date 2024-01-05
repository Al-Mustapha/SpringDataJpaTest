package com.example.SpringDataJpaTest;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class Teacher {
    @SequenceGenerator(name = "teacher_gen",sequenceName = "teacher_gen",allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacher_gen"
    )
    @Id
    private Long teacherId;
    private String firstName;
    private String lastName;

//    @OneToMany(
//            mappedBy = "teacher",fetch = FetchType.LAZY, cascade = CascadeType.ALL
//    )
//    private List<Course> courses;

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
