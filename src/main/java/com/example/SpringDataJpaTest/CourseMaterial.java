package com.example.SpringDataJpaTest;


import jakarta.persistence.*;
import lombok.*;

@Entity@Setter@Getter@AllArgsConstructor@NoArgsConstructor@Builder
public class CourseMaterial {
    @SequenceGenerator(name = "mat",sequenceName = "mat",allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "mat"
    )
    @Id
    Long courseMaterialId;
    String url;

//    @OneToOne(
//            mappedBy = "courseMaterial", fetch = FetchType.LAZY, cascade = CascadeType.ALL
//    )
//    private Course course;

    @Override
    public String toString() {
        return "CourseMaterial{" +
                "courseMaterialId=" + courseMaterialId +
                ", url='" + url + '\'' +
                '}';
    }
}

