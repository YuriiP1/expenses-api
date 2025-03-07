package com.example.expensesapi.repository;

import com.example.expensesapi.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
    @Transactional
    List<Expenses> deleteByDate(Date date);
}
