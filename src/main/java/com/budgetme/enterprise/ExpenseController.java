package com.budgetme.enterprise;

import com.budgetme.enterprise.dao.ExpenseInput;
import com.budgetme.enterprise.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
