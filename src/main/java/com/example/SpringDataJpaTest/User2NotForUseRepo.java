package com.example.SpringDataJpaTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User2NotForUseRepo extends JpaRepository<User2NotForUse, Long> {
}
