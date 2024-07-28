package com.budgetme.enterprise.service;
import com.budgetme.enterprise.dao.ExpenseInput;
import com.budgetme.enterprise.repository.ExpenseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.budgetme.enterprise.dao.User;
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

    public List<ExpenseInput> getExpensesByUserAndType(User user, String type) {
        return expenseRepository.findByUserAndType(user, type);
    }
    //private static final Logger logger = LoggerFactory.getLogger(ExpenseService.class);
    @Transactional
    public boolean deleteAllExpensesByUser(User user) {
        try {
            //logger.info("Attempting to delete expenses for user: {}", user.getUsername());
            expenseRepository.deleteByUser(user);
            //logger.info("Expenses deleted successfully for user: {}", user.getUsername());
            return true;
        } catch (Exception e) {
            //logger.error("Error deleting expenses for user: {}", user.getUsername(), e);
            return false;
        }
    }
}
