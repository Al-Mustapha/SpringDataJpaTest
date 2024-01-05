package com.example.SpringDataJpaTest;


import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.OverridesAttribute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable

@AttributeOverride(
        name = "name",
        column = @Column(name = "GuardianName")
)
@AttributeOverride(
        name = "guardianEmail",
        column = @Column(name = "GuardianEmail")
)
@AttributeOverride(
        name = "guardianPhone",
        column = @Column(name = "GuardianPhone")
)
public class StudentGuardian {

    private String guardianName;
    private String guardianEmail;
    private String guardianPhone;

}
