package com.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel {
    private String name;
    private String department;
    private String guardianName;
    private String guardianEmail;
    private String guardianPhone;
}
