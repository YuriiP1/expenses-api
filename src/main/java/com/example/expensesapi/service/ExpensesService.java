package com.example.expensesapi.service;

import com.example.expensesapi.model.Expenses;
import com.example.expensesapi.repository.ExpensesRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExpensesService {

    public final ExpensesRepository expensesRepository;

    public ExpensesService(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    public List<Expenses> findAll() {
        return expensesRepository.findAll();
    }

    public Expenses save(Expenses expenses) {
        return expensesRepository.save(expenses);
    }

    public void deleteByDate(Date date) {
        expensesRepository.deleteByDate(date);
    }
}
