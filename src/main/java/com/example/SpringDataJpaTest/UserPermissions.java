package com.example.SpringDataJpaTest;

import java.util.Set;

import static com.example.SpringDataJpaTest.ApplicationUserPermission.*;
import static com.google.common.collect.Sets.newHashSet;

public enum UserPermissions {
    STUDENT(newHashSet()),
    ADMIN(newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_WRITE, STUDENT_READ));

    private final Set<ApplicationUserPermission> userAdmin;

    UserPermissions(Set<ApplicationUserPermission> userAdmin) {
        this.userAdmin = userAdmin;
    }
}
