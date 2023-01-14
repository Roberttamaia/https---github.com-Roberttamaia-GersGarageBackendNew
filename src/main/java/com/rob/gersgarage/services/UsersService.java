package com.rob.gersgarage.services;

import com.rob.gersgarage.model.Users;
import com.rob.gersgarage.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    public Users saveUser(Users users){
        return usersRepository.save(users);
    }
    public List<Users> saveUsers(List<Users> users){
        return usersRepository.saveAll(users);
    }
    public List<Users> getUsers(){
        return usersRepository.findAll();
    }
    public Users getUserById(Long id){
        return usersRepository.findById(id).orElse(null);
    }
    public Users getUserByName(String name){
        return usersRepository.findByName(name);
    }

    public String deleteUser(Long id){
        usersRepository.deleteById(id);
        return "user has been deleted" +id;
    }

    public Users updateUser(Users users){
        Users existingUser=usersRepository.findById(users.getId()).orElse(null);
        existingUser.setName(users.getName());
        existingUser.setFirstName(users.getFirstName());
        existingUser.setLastName(users.getLastName());
        existingUser.setEmail(users.getEmail());
        existingUser.setRole(users.getRole());
        return usersRepository.save(existingUser);
    }
}

