package com.budgetme.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for handling web requests to the home page.
 */
@Controller
public class BudgetMeController {

    /**
     * Handles requests to the root URL and returns the name of the start page view.
     * @return the name of the start page view.
     */
    @RequestMapping("/")
    public String index(){
        return "start";
    }
}
