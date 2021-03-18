package com.example.JavaAcademy.Service;


import com.example.JavaAcademy.Model.CustomUserDetails;
import com.example.JavaAcademy.Model.User;
import com.example.JavaAcademy.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       User user = repo.findByUserName(userName);

        if (user == null){
            throw new UsernameNotFoundException("User with " + userName + " doesn't exist");
        }
        return new CustomUserDetails(user);
    }

}
