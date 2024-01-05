package com.example.SpringDataJpaTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DatabaseRepo extends JpaRepository<NewUsers, Long>{

    @Query("SELECT s from Users s where s.username=:username")
    NewUsers fetchByUsername(@Param("username") String username);

    @Query("SELECT s from Users s where s.username=:username")
    public NewUsers findByUsername(@Param("username") String username);

    @Query("SELECT s FROM Users s WHERE s.username =:username AND s.password=:password")
    public NewUsers findByUsernameAndPassword(@Param("username") String username, String password);


    @Query("SELECT s FROM Users s WHERE s.username=:username")
    public String getRoleByUsername(@Param("username") String username);
    
}
