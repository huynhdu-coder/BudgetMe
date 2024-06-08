package com.budgetme.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BudgetMeController {
    @RequestMapping("/")
    public String index(){
        return "start";
    }
}
