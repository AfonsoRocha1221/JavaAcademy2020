package com.example.JavaAcademy.Service;


import com.example.JavaAcademy.Model.User;
import com.example.JavaAcademy.Repository.UserRepository;
import com.example.JavaAcademy.Security.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    /**
     * Update user user.
     *
     * @param user the user
     * @return the user
     */
    public User updateUser(User user) {
        Optional<User> userDb = this.repository.findById(user.getId());

        if (userDb.isPresent()) {
            User existingUser = userDb.get();
            existingUser.setUserName(user.getUserName());
            existingUser.setName(user.getName());
            existingUser.setPassword(user.getPassword());
            existingUser.setUpdateTimeStamp(LocalDateTime.now());

            return repository.save(existingUser);
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + user.getId());
        }
    }

    public boolean CheckIfUsernameExists(String userName) {
        List<User> users = repository.findAll();
        boolean userExists = false;

        for (User user : users)
            if (users.contains(user.getUserName())) {
                return true;
            } else {
                throw new ResourceNotFoundException(" Username " + userName + "already exists");
            }
        return false;
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

    @Override
    public User getUserById(long id) {
        Optional<User> optional = repository.findById(id);
        User user;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new ResourceNotFoundException(" User not found for id -> " + id);
        }
        return user;
    }

    @Override
    public void deleteUserById(long id) {
        Optional<User> userDb = this.repository.findById(id);

        if(userDb.isPresent()) {
            this.repository.delete(userDb.get());
        }else {
            throw new ResourceNotFoundException("User not found with id : " + id);
        }
    }


   /* public Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.repository.findAll(pageable);
    }*/
}









