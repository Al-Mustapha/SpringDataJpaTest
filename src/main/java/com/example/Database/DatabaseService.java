package com.example.Database;

import com.example.Model.UserModel;
import com.example.SpringDataJpaTest.DatabaseRepo;
import com.example.SpringDataJpaTest.NewUsers;
import com.example.SpringDataJpaTest.Users;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"com.example.Database"})
public class DatabaseService implements UserDetailsService {
    @Autowired
    private DatabaseRepo databaseRepo;

    public List<NewUsers> getUser(){
        return databaseRepo.findAll();
    }
    public NewUsers getOneUser(String username){
        return databaseRepo.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return databaseRepo.fetchByUsername(username);
    }

    public UserModel saveUser(UserModel model) {
        NewUsers users = new NewUsers();
        BeanUtils.copyProperties(model, users);
        databaseRepo.save(users);
        return model;
    }

    public NewUsers getUserByUsername(String username) {
        return databaseRepo.fetchByUsername(username);
    }

    public void deleteStudent(Long id) {
        databaseRepo.deleteById(id);
    }

    public void updateStudent(Long id, UserModel model) {
        NewUsers user = databaseRepo.findById(id).get();
        user.setUsername(model.getUsername());
        user.setPassword(model.getPassword());
        user.setRole(model.getRole());
        databaseRepo.save(user);
    }

    public NewUsers getUserById(Long id) {
       return databaseRepo.findById(id).get();
    }

    public List<NewUsers> getUsers() {
        return databaseRepo.findAll();
    }
}
