package com.budgetme.enterprise;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BudgetMeController {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public ExpenseRepository expenseRepository;

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
    public String createUser(@RequestParam String Username, @RequestParam String Password){
        User user = userRepository.findByUsername(Username);

        if (user != null) {
            return "createUser";
        }
        else {
            try {
                User saveUser = new User();

                saveUser.setUsername(Username);
                saveUser.setPassword(Password);
                saveUser.setIsLoggedIn(true);

                userRepository.save(saveUser);

                return "dashboard";
            }
            catch (Exception e) {
                return "createUser";
            }
        }
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
