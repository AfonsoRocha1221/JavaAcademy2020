package com.example.JavaAcademy.Controller;



import com.example.JavaAcademy.Model.User;

import com.example.JavaAcademy.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * The type App controller.
 */
@Controller
public class AppController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * View home page string.
     *
     * @return the string
     */
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    /**
     * Show sign up form string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    /**
     * Add user string.
     *
     * @param user the user
     * @return the string
     */
    @PostMapping("/process_register")
    public String addUser(User user) {
        userServiceImpl.saveUser(user);
        return "register_success";

    }

    /**
     * Show new user form string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    /**
     * Show for for update string.
     *
     * @param id    the id
     * @param model the model
     * @return the string
     */
    @GetMapping("/showFormUpdate/{id}")
    public String showForForUpdate(@PathVariable(value = "id") Long id, Model model) {
        User user = userServiceImpl.getUserById(id);
        model.addAttribute("user", user);
        return "update_user";
    }

    /**
     * Delete user by id string.
     *
     * @param id the id
     * @return the string
     */
    @GetMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable (value = "id") Long id) {
        userServiceImpl.deleteUserById(id);
        return "register_success";
    }

    /**
     * List all users string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/list_users")
    public String listAllUsers(Model model) {
        model.addAttribute("listUsers", userServiceImpl.getAllUsers());
        return "users";

    }

    /**
    @GetMapping("/")
    public String ListPage(Model model) {
        return findPaginated(1, "userName", "asc", model);
    }



    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<User> page = userServiceImpl.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<User> listUsers = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listUsers", listUsers);
        return "users";
    }

     **/


}




