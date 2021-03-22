package com.example.expensesapi.repository;

import com.example.expensesapi.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
    void deleteByDate(Date date);
}
