package com.example.expensesapi.controller;

import com.example.expensesapi.model.Expenses;
import com.example.expensesapi.service.ExpensesService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ExpensesController {

    private final ExpensesService expensesService;
    private final RestTemplate restTemplate;

    public ExpensesController(ExpensesService expensesService, RestTemplate restTemplate) {
        this.expensesService = expensesService;
        this.restTemplate = restTemplate;
    }


    @GetMapping("/expenses")
    public Map<Date, List<Expenses>> showAll() {

        List<Expenses> list = expensesService.findAll();
        Map<Date, List<Expenses>> map = list
                .stream()
                .collect(Collectors.groupingBy(Expenses::getDate));

        return map;
    }

    @PostMapping("/expenses")
    public Expenses save(@RequestBody Expenses expenses) {
        expenses.setId(expensesService.count() + 1);
        return expensesService.save(expenses);
    }

    @DeleteMapping("/expenses")
    public List<Expenses> deleteByDate(@RequestParam("date")
                                                   @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<Expenses> deleteExpenses = expensesService.deleteByDate(date);
        return deleteExpenses;
    }

    @GetMapping("/total")
    public Map<String, Object> getTotal(@RequestParam String base) {

        double total = expensesService.getTotal(base);

        Map<String, Object> map = new HashMap<>();

        map.put("total",total);
        map.put("currency", base);

        return map;
    }

}
