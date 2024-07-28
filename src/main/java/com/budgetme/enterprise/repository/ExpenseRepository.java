package com.budgetme.enterprise.repository;
import com.budgetme.enterprise.dao.User;
import com.budgetme.enterprise.dao.ExpenseInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseInput, Long> {
    List<ExpenseInput> findByUserAndType(User user, String type);
}
