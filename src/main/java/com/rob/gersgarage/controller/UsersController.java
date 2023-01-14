package com.rob.gersgarage.controller;

import com.rob.gersgarage.model.Users;
import com.rob.gersgarage.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/addUser")
    public Users addUser(@RequestBody Users users){
        return usersService.saveUser(users);
    }
    @PostMapping("/addUsers")
    public List<Users> addUsers(@RequestBody List<Users> users){
        return usersService.saveUsers(users);
    }
    @GetMapping("/users")
    public List<Users> findAllUsers(){
        return usersService.getUsers();
    }

    @GetMapping("/getUserById/{id}")
    public Users findUserById(@PathVariable Long id){
        return usersService.getUserById(id);
    }
    @GetMapping("/user/{name}")
    public Users findUserByName(@PathVariable String name){
        return usersService.getUserByName(name);
    }
    @PutMapping("/updateUser")
    public Users updateUser(@RequestBody Users users){
        return usersService.updateUser(users);
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return usersService.deleteUser(id);
    }

}









