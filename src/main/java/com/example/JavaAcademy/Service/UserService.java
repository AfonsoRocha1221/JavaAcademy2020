package com.example.JavaAcademy.Service;

import com.example.JavaAcademy.Model.User;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);

    //Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
