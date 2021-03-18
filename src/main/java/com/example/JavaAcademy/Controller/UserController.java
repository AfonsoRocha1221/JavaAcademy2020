package com.example.JavaAcademy.Controller;


import com.example.JavaAcademy.Model.User;
import com.example.JavaAcademy.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/users"))
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @PostMapping
    public void addUser (@RequestBody User user){
        this.service.saveUser(user);

    }
    @GetMapping
    public List<User> getUsers () {
        return service.getAllUsers();
    }

    @DeleteMapping("{id}")
    public String deleteUserById (@PathVariable Long id) {
        return service.deleteUserById(id);

    }

    @PutMapping
    public User updateUser (@RequestBody User user ){
        return service.updateUser(user);
    }

}
