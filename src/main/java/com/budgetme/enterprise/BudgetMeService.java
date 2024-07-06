package com.budgetme.enterprise;

import org.springframework.stereotype.Service;

@Service
public class BudgetMeService {
    public String getHomePage() {
        return "start";
    }
}
