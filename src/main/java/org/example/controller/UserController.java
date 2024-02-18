package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    boolean saveUser(@RequestBody User user){
        return userService.addUsers(user);
    }
    @PostMapping("/get")
    boolean loginUser(@RequestBody User user){
        return userService.loginUser(user);
    }
    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
