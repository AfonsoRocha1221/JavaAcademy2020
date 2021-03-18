package com.example.JavaAcademy.Service;


import com.example.JavaAcademy.Model.User;
import com.example.JavaAcademy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        assert existingUser != null;
        existingUser.setUserName(user.getUserName());
        existingUser.setName(user.getName());
        existingUser.setPassword(user.getPassword());
        existingUser.setUpdateTimeStamp(LocalDateTime.now());

        return repository.save(existingUser);
    }


    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public void saveUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setCreateTimeStamp(LocalDateTime.now());
        this.repository.save(user);
    }


    public User getUserById(long id) {
        Optional<User> optional = repository.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" User not found for id -> " + id);
        }
        return user;
    }


    public String deleteUserById(long id) {
        this.repository.deleteById(id);
        return "User with id " + id + " has been removed";
    }


   /* public Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.repository.findAll(pageable);
    }*/
}









