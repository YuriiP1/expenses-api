package com.example.expensesapi.controller;

import com.example.expensesapi.model.Expenses;
import com.example.expensesapi.service.ExpensesService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
public class ExpensesController {

    private final ExpensesService expensesService;

    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    @GetMapping("/expenses")
    public List<Expenses> showAll() {
        List<Expenses> expenses = expensesService.findAll();

        Collections.sort(expenses, (e1, e2) ->
                Long.valueOf(e1.getDate().getTime())
                        .compareTo(e2.getDate().getTime())
        );

        return expenses;
    }

    @PostMapping("/expenses")
    public Expenses save(@RequestBody Expenses expenses) {

        return expensesService.save(expenses);
    }

    @DeleteMapping("/expenses")
    public ResponseEntity<String> deleteByDate(@RequestParam("date")
                                                   @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        expensesService.deleteByDate(date);
        return ResponseEntity.ok("DELETED");
    }

}
