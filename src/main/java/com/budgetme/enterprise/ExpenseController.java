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
import java.util.stream.Collectors;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/input")
    public String showExpenseInputForm(Model model) {
        model.addAttribute("expenseInput", new ExpenseInput());
        return "expenseInput";
    }

    @PostMapping("/input")
    public String handleExpenseInput(@RequestParam String description, @RequestParam Double price, @RequestParam String type, Model model) {
        ExpenseInput expenseInput = new ExpenseInput();
        expenseInput.setDescription(description);
        expenseInput.setPrice(price);
        expenseInput.setType(type);
        expenseService.saveExpense(expenseInput);
        model.addAttribute("message", "Expense saved successfully!");
        return "expenseInput";
    }

    @GetMapping("/list")
    public String listExpenses(Model model) {
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "expenseList";
    }

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
