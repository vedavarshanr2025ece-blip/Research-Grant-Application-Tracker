package com.example.grantTrack.service;

import com.example.grantTrack.entity.Application;
import com.example.grantTrack.entity.Expenditure;
import com.example.grantTrack.repository.ApplicationRepository;
import com.example.grantTrack.repository.ExpenditureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenditureService {

    private final ExpenditureRepository expenditureRepository;
    private final ApplicationRepository applicationRepository;

    public ExpenditureService(ExpenditureRepository expenditureRepository,
                              ApplicationRepository applicationRepository) {
        this.expenditureRepository = expenditureRepository;
        this.applicationRepository = applicationRepository;
    }

    // Add Expenditure
    public Expenditure addExpense(Expenditure expenditure,
                                  Integer applicationId) {

        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        expenditure.setApplication(application);

        return expenditureRepository.save(expenditure);
    }

    // Get All Expenditures
    public List<Expenditure> getAllExpenses() {
        return expenditureRepository.findAll();
    }

    // Get Expenditures by Application
    public List<Expenditure> getApplicationExpenses(Integer applicationId) {

        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        return expenditureRepository.findByApplication(application);
    }

    // Delete Expenditure
    public void deleteExpense(Integer id) {
        expenditureRepository.deleteById(id);
    }

    public Expenditure updateExpense(Integer id,
                                     Expenditure updatedExpense){

        Expenditure expense = expenditureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        expense.setTitle(updatedExpense.getTitle());
        expense.setAmount(updatedExpense.getAmount());
        expense.setDateIncurred(updatedExpense.getDateIncurred());
        expense.setDescription(updatedExpense.getDescription());
        expense.setIsApproved(updatedExpense.getIsApproved());

        return expenditureRepository.save(expense);
    }
}