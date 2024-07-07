package com.budgetme.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BudgetMeController {
    @RequestMapping("/")
    public String index(){
        return "start";
    }

    @PostMapping("/create_user")
    public String createUser(@RequestParam String Username, @RequestParam String Password){
        return "dashboard";
    }

    @PostMapping("/login_user")
    public String loginUser(@RequestParam String Username, @RequestParam String Password, Model model){
        return "dashboard";
    }

    @GetMapping("/create_user")
    public String showCreateUser(){
        return "createUser";
    }

    @GetMapping("/login_user")
    public String showLoginUser(){
        return "loginUser";
    }
}
