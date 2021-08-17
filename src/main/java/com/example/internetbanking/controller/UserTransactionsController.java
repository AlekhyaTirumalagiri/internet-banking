package com.example.internetbanking.controller;

import com.example.internetbanking.model.UserTransactions;
import com.example.internetbanking.service.ServiceImpl.UserTransactionsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserTransactionsController {

    private static final Logger log = LoggerFactory.getLogger(UserTransactionsController.class);

    @Autowired
    private UserTransactionsServiceImpl userTransactionImpl;

    @GetMapping("/api/allTransactions/{category}")
    public List<UserTransactions> getAllUserTransactionsByCategory(@PathVariable("category") String category) throws Exception {
        log.info("All transactions for a given category - latest first");
        try {
            return userTransactionImpl.getAllUserTransactionsByCategory(category.trim());
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/api/totalOutgoing/{category}")
    public double getTotalOutgoingTransactionsPerCategory(@PathVariable("category") String category) throws Exception {
        log.info("Total outgoing per category");
        try {
            return userTransactionImpl.getTotalOutgoingPerCategory(category.trim());
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/api/monthlyAverageSpend/{category}")
    public List<Map<String, Double>> getMonthlyAverageSpendPerCategory(@PathVariable("category") String category) throws Exception {
        log.info("Monthly average spend in a given category");
        try {
            return userTransactionImpl.getMonthlyAverageSpendPerCategory(category.trim());
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/api/amountSpend/{category}/{year}")
    public Map<String, Double> getAmountSpentByCategoryAndYear(@PathVariable("category") String category,
                                                               @PathVariable("year") String year) throws Exception {
        log.info("Highest and Lowest spend amount in a given category, for a given year");
        try {
            return userTransactionImpl.getAmountSpentByCategoryAndYear(category.trim(), year.trim());
        } catch (Exception e) {
            throw e;
        }
    }

}
