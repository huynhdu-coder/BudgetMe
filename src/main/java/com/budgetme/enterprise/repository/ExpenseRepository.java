package com.budgetme.enterprise.repository;
import com.budgetme.enterprise.dao.ExpenseInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseInput, Long> {
}
