package com.budgetme.enterprise;

import com.budgetme.enterprise.dao.User;
import com.budgetme.enterprise.repository.UserRepository;
import com.budgetme.enterprise.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BudgetMeController {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public String index(HttpSession session){
        User user = (User) session.getAttribute("user");

        if (user != null) {
            return "dashboard";
        }

        return "start";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        User user = (User) session.getAttribute("user");

        if (user != null) {
            user.setIsLoggedIn(false);
            userRepository.save(user);

            session.setAttribute("user", null);
        }
        return "start";
    }

    @PostMapping("/create_user")
    public String createUser(@RequestParam String username, @RequestParam String password) {
        userService.createUser(username, password);
        return "/dashboard";
    }

    @PostMapping("/login_user")
    public String loginUser(@RequestParam String Username, @RequestParam String Password, Model model, HttpSession session){
        User user = userRepository.findByUsername(Username);

        if (user != null) {
            if (user.getPassword().equals(Password)) {
                user.setIsLoggedIn(true);
                userRepository.save(user);

                session.setAttribute("user", user);
            }
            else {
                return "loginUser";
            }
        }
        else {
            return "loginUser";
        }

        return "dashboard";
    }

    @GetMapping("/create_user")
    public String showCreateUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return "dashboard";
        }
        return "createUser";
    }

    @GetMapping("/login_user")
    public String showLoginUser(HttpSession session){
        User user = (User) session.getAttribute("user");

        if (user != null) {
            return "dashboard";
        }

        return "loginUser";
    }
}