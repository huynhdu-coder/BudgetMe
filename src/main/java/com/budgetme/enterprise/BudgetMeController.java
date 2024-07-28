package com.budgetme.enterprise;

import com.budgetme.enterprise.dao.User;
import com.budgetme.enterprise.repository.UserRepository;
import com.budgetme.enterprise.service.ExpenseService;
import com.budgetme.enterprise.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controller class for handling requests related to user management and navigation in the BudgetMe application.
 */
@Controller
public class BudgetMeController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ExpenseService expenseService;

    /**
     * Handles the root ("/") URL request.
     * Redirects to the dashboard if a user is logged in, otherwise shows the start page.
     *
     * @param session the HTTP session
     * @return the name of the view to render
     */
    @RequestMapping("/")
    public String index(HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            return "dashboard";
        }

        return "start";
    }

    /**
     * Handles the logout request.
     * Logs out the user and redirects to the start page.
     *
     * @param session the HTTP session
     * @return the name of the view to render
     */
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            user.setIsLoggedIn(false);
            userRepository.save(user);

            session.setAttribute("user", null);
        }
        return "start";
    }

    /**
     * Handles the request to create a new user.
     * Creates a new user and redirects to the dashboard.
     *
     * @param username the username of the new user
     * @param password the password of the new user
     * @return the name of the view to render
     */
    @PostMapping("/create_user")
    public String createUser(@RequestParam String username, @RequestParam String password) {
        userService.createUser(username, password);
        return "dashboard";
    }

    /**
     * Handles the login request.
     * Logs in the user if the credentials are correct and redirects to the dashboard.
     * If the credentials are incorrect, shows the login page again.
     *
     * @param Username the username
     * @param Password the password
     * @param model    the model
     * @param session  the HTTP session
     * @return the name of the view to render
     */
    @PostMapping("/login_user")
    public String loginUser(@RequestParam String Username, @RequestParam String Password, Model model, HttpSession session) {
        User user = userRepository.findByUsername(Username);

        if (user != null) {
            if (user.getPassword().equals(Password)) {
                user.setIsLoggedIn(true);
                userRepository.save(user);

                session.setAttribute("user", user);
            } else {
                return "loginUser";
            }
        } else {
            return "loginUser";
        }

        return "dashboard";
    }

    /**
     * Handles the request to show the create user page.
     * Redirects to the dashboard if a user is logged in, otherwise shows the create user page.
     *
     * @param session the HTTP session
     * @return the name of the view to render
     */
    @GetMapping("/create_user")
    public String showCreateUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return "dashboard";
        }
        return "createUser";
    }

    /**
     * Handles the request to show the login page.
     * Redirects to the dashboard if a user is logged in, otherwise shows the login page.
     *
     * @param session the HTTP session
     * @return the name of the view to render
     */
    @GetMapping("/login_user")
    public String showLoginUser(HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            return "dashboard";
        }

        return "loginUser";
    }
    /**
     * Returns the logged In Username
     */
    @GetMapping("/api/username")
    @ResponseBody
    public String getUsername(HttpSession session) {
        User loggedInUser = (User) session.getAttribute("user");
        if (loggedInUser == null) {
            return "start";
        }
        return loggedInUser.getUsername();
    }

}