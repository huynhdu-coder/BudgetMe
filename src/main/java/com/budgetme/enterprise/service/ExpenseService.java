package com.budgetme.enterprise.service;
import com.budgetme.enterprise.dao.ExpenseInput;
import com.budgetme.enterprise.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<ExpenseInput> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public ExpenseInput saveExpense(ExpenseInput expenseInput) {
        return expenseRepository.save(expenseInput);
    }
}
