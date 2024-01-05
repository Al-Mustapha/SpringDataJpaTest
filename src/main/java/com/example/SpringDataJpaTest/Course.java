package com.example.SpringDataJpaTest;

import jakarta.persistence.*;
import lombok.*;

@Entity@AllArgsConstructor@NoArgsConstructor@Builder@Getter@Setter
public class Course {
    @SequenceGenerator(name = "course_gen",sequenceName = "course-gen",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_gen" )
    @Id
    Long courseId;
    String title;
    String unit;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false    )
    @JoinColumn(name = "course_material_id",referencedColumnName = "courseMaterialId")
    private CourseMaterial courseMaterial;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false    )
    @JoinColumn(name = "teacher_id_column",referencedColumnName = "teacherId")
    private Teacher teacher;
    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", unit='" + unit + '\'' +
                ", courseMaterial=" + courseMaterial +
                ", teacher=" + teacher +
                '}';
    }
}
