package com.example.JavaAcademy.Repository;

import com.example.JavaAcademy.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * The interface User repository.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find by user name user.
     *
     * @param userName the user name
     * @return the user
     */
    @Query("SELECT u FROM User  u WHERE u.userName = ?1 ")
    User findByUserName (String userName);
}
