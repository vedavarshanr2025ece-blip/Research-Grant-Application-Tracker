package com.example.grantTrack.controller;

import com.example.grantTrack.entity.Expenditure;
import com.example.grantTrack.service.ExpenditureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenditure")
@CrossOrigin(origins = "*")
public class ExpenditureController {

    private final ExpenditureService expenditureService;

    public ExpenditureController(ExpenditureService expenditureService) {
        this.expenditureService = expenditureService;
    }

    @PostMapping("/add/{applicationId}")
    public Expenditure addExpense(
            @RequestBody Expenditure expenditure,
            @PathVariable Integer applicationId) {

        return expenditureService.addExpense(expenditure, applicationId);
    }

    @GetMapping
    public List<Expenditure> getAllExpenses() {
        return expenditureService.getAllExpenses();
    }

    @GetMapping("/find/application/{applicationId}")
    public List<Expenditure> getApplicationExpenses(
            @PathVariable Integer applicationId) {

        return expenditureService.getApplicationExpenses(applicationId);
    }
    @PutMapping("/edit/{id}")
    public Expenditure updateExpense(@PathVariable Integer id,
                                     @RequestBody Expenditure expenditure){
        return expenditureService.updateExpense(id, expenditure);
    }

    @DeleteMapping("/del/{id}")
    public String deleteExpense(@PathVariable Integer id) {
        expenditureService.deleteExpense(id);
        return "Expense deleted successfully";
    }
}