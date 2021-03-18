package com.example.JavaAcademy.Service;

import com.example.JavaAcademy.Model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(long id);
    String deleteUserById(long id);
    //Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
