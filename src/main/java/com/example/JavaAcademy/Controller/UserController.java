package com.example.JavaAcademy.Controller;


import com.example.JavaAcademy.Model.User;
import com.example.JavaAcademy.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type User controller.
 */
@RestController
@RequestMapping(("/users"))
public class UserController {

    @Autowired
    private UserServiceImpl service;

    /**
     * Add user.
     *
     * @param user the user
     */
    @PostMapping
    public void addUser (@RequestBody User user){
        this.service.saveUser(user);

    }

    /**
     * Gets users.
     *
     * @return the users
     */
    @GetMapping
    public List<User> getUsers () {
        return service.getAllUsers();
    }

    /**
     * Delete user by id string.
     *
     * @param id the id
     * @return the string
     */
    @DeleteMapping("{id}")
    public void deleteUserById (@PathVariable Long id) {
        service.deleteUserById(id);

    }

    /**
     * Update user user.
     *
     * @param user the user
     * @return the user
     */
    @PutMapping
    public User updateUser (@RequestBody User user ){
        return service.updateUser(user);
    }

}
