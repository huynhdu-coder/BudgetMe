package com.budgetme.enterprise;

import com.budgetme.enterprise.dao.ExpenseInput;
import com.budgetme.enterprise.dao.User;
import com.budgetme.enterprise.service.ExpenseService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

/**
 * Controller class for handling requests related to expense management in the BudgetMe application.
 */
@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    /**
     * Handles the request to show the expense input form.
     * Adds an empty ExpenseInput object to the model to bind the form data.
     *
     * @param model the model to add attributes to
     * @return the name of the view to render
     */
    @GetMapping("/input")
    public String showExpenseInputForm(Model model) {
        model.addAttribute("expenseInput", new ExpenseInput());
        return "expenseInput";
    }

    /**
     * Handles the submission of the expense input form.
     * Creates a new expense based on the form data and saves it.
     * Adds a success message to the model and redirects to the dashboard.
     *
     * @param description the description of the expense
     * @param price       the price of the expense
     * @param type        the type of the expense
     * @param model       the model to add attributes to
     * @param session     the HTTP session
     * @return the name of the view to render
     */
    @PostMapping("/input")
    public String handleExpenseInput(@RequestParam String description, @RequestParam Double price, @RequestParam String type, Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("user");
        ExpenseInput expenseInput = new ExpenseInput();
        expenseInput.setDescription(description);
        expenseInput.setPrice(price);
        expenseInput.setType(type);
        expenseInput.setUser(loggedInUser); // Set the logged-in user
        expenseService.saveExpense(expenseInput);
        model.addAttribute("message", "Expense saved successfully!");
        return "dashboard";
    }

    /**
     * Handles the request to list all expenses.
     * Adds all expenses to the model.
     *
     * @param model the model to add attributes to
     * @return the name of the view to render
     */
    @GetMapping("/list")
    public String listExpenses(Model model) {
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "expenseList";
    }

    /**
     * API endpoint to get all planned expenses for the logged-in user.
     * Returns a list of planned expenses for the logged-in user.
     *
     * @param session the HTTP session
     * @return a list of planned expenses
     */
    @GetMapping("/api/planned")
    @ResponseBody
    public List<ExpenseInput> getPlannedExpenses(HttpSession session) {
        User loggedInUser = (User) session.getAttribute("user");
        if (loggedInUser == null) {
            return Collections.emptyList();
        }

        // Fetch planned expenses for the logged-in user
        return expenseService.getExpensesByUserAndType(loggedInUser, "planned");
    }
}
