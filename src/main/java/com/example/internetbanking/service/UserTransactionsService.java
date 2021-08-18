package com.example.internetbanking.service;

import com.example.internetbanking.controller.UserTransactionsController;
import com.example.internetbanking.model.UserTransactions;
import com.example.internetbanking.repository.UserTransactionRepository;
import com.example.internetbanking.service.ServiceImpl.UserTransactionsServiceImpl;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserTransactionsService implements UserTransactionsServiceImpl {

    private static final Logger log = LoggerFactory.getLogger(UserTransactionsController.class);

    @Autowired
    private UserTransactionRepository userTransactionRepository;

    public List<UserTransactions> getAllUserTransactionsByCategory(String category) throws Exception {
        log.info("Inside getAllUserTransactionsByCategory method");
        try {
            if (!Strings.isNullOrEmpty(category.trim())) {
                return userTransactionRepository.getAllUserTransactionsByCategory(category.trim());
            } else {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            throw e;
        }

    }

    public Map<String, Double> getAmountSpentByCategoryAndYear(@Param("category") String category,
                                                               @Param("year") String year) throws Exception {
        log.info("Inside getAmountSpentByCategoryAndYear method");
        try {
            if (!Strings.isNullOrEmpty(category.trim()) && !Strings.isNullOrEmpty(year.trim())) {
                return userTransactionRepository.getAmountSpentByCategoryAndYear(category.trim(), year.trim());
            } else {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public double getTotalOutgoingPerCategory(@Param("category") String category) throws Exception {
        log.info("Inside getTotalOutgoingPerCategory method");
        try {
            if (!Strings.isNullOrEmpty(category.trim())) {
                return userTransactionRepository.getTotalOutgoingPerCategory(category.trim());
            } else {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Map<String, Double>> getMonthlyAverageSpendPerCategory(@Param("category") String category) throws Exception {
        log.info("Inside getMonthlyAverageSpendPerCategory method");
        try {
            if (!Strings.isNullOrEmpty(category.trim())) {
                List<Map<String, Double>> result = userTransactionRepository.getMonthlyAverageSpendPerCategory(category.trim());
                return result;
            } else {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
