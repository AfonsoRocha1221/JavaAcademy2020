package com.example.JavaAcademy.Service;

import com.example.JavaAcademy.Model.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Gets all users.
     *
     * @return the all users
     */
    List<User> getAllUsers();

    /**
     * Save user.
     *
     * @param user the user
     */
    void saveUser(User user);

    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     */
    User getUserById(long id);

    /**
     * Delete user by id string.
     *
     * @param id the id
     * @return the string
     */
    String deleteUserById(long id);
    //Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
