package com.example.crud.controller;

import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){

        return userService.saveUser(user);
    }

    @GetMapping("/fetchUsers")
    public List<User> fetchAllUsers(){

        return userService.fetchAllUsers();
    }

    @GetMapping("/fetchUserById/{id}")
    public User fetchUserById(@PathVariable("id") Long id){

        return userService.findUserByID(id);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUserById(@PathVariable("id") Long id,@RequestBody User user){
        return userService.updateUserByID(id, user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable("id") Long id){

        return userService.deleteUser(id);
    }
}








