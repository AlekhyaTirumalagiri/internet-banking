package com.example.internetbanking.controller;

import com.example.internetbanking.model.UserTransactions;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserTransactionsControllerTest {

    @Autowired
    private UserTransactionsController userTransactionsController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(userTransactionsController).isNotNull();
    }

    @Test
    public void passesValidationWhenFetchingAllUserTransactionsByCategory() throws Exception {
        List<UserTransactions> expectedResult = userTransactionsController.getAllUserTransactionsByCategory("groceries");
        Assert.assertEquals(2, expectedResult.size());
    }

    @Test
    public void passesValidationWhenFetchingAllUserTransactionsByAnotherCategory() throws Exception {
        List<UserTransactions> expectedResult = userTransactionsController.getAllUserTransactionsByCategory("MyMonthlyDD");
        Assert.assertEquals(2, expectedResult.size());
    }

    @Test
    public void failValidationWhenFetchingAllUserTransactionsByNullCategory() {
        Assertions.assertThrows(Exception.class, () -> {
            userTransactionsController.getAllUserTransactionsByCategory(null);
        });
    }

    @Test
    public void failValidationWhenFetchingAllUserTransactionsByEmptyCategory() {
        Assertions.assertThrows(Exception.class, () -> {
            userTransactionsController.getAllUserTransactionsByCategory(" ");
        });
    }

    @Test
    public void passesValidationForGetTotalOutgoingTransactionsPerCategory() throws Exception {
        double expectedResult = userTransactionsController.getTotalOutgoingTransactionsPerCategory("groceries");
        Assert.assertEquals(16.39, expectedResult, 0.1);
    }

    @Test
    public void passesValidationForGetTotalOutgoingTransactionsPerAnotherCategory() throws Exception {
        double expectedResult = userTransactionsController.getTotalOutgoingTransactionsPerCategory("MyMonthlyDD");
        Assert.assertEquals(640.00, expectedResult, 0.1);
    }

    @Test
    public void failValidationForGetTotalOutgoingTransactionsPerNullCategory() {
        Assertions.assertThrows(Exception.class, () -> {
            userTransactionsController.getTotalOutgoingTransactionsPerCategory(null);
        });
    }

    @Test
    public void failValidationForGetTotalOutgoingTransactionsPerEmptyCategory() {
        Assertions.assertThrows(Exception.class, () -> {
            userTransactionsController.getTotalOutgoingTransactionsPerCategory(" ");
        });
    }

    @Test
    public void passesValidationForGetMonthlyAverageSpendPerCategory() throws Exception {
        List<Map<String, Double>> expectedResult = userTransactionsController.getMonthlyAverageSpendPerCategory("groceries");
        Assert.assertEquals(2, expectedResult.size());
    }

    @Test
    public void passesValidationForGetMonthlyAverageSpendPerAnotherCategory() throws Exception {
        List<Map<String, Double>> expectedResult = userTransactionsController.getMonthlyAverageSpendPerCategory("MyMonthlyDD");
        Assert.assertEquals(1, expectedResult.size());
    }

    @Test
    public void failValidationForGetMonthlyAverageSpendPerNullCategory() {
        Assertions.assertThrows(Exception.class, () -> {
            userTransactionsController.getMonthlyAverageSpendPerCategory(null);
        });
    }

    @Test
    public void failValidationForGetMonthlyAverageSpendPerEmptyCategory() {
        Assertions.assertThrows(Exception.class, () -> {
            userTransactionsController.getMonthlyAverageSpendPerCategory(" ");
        });
    }

    @Test
    public void passesValidationForGetAmountSpentByCategoryAndYear() throws Exception {
        Map<String, Double> expectedResult = userTransactionsController.getAmountSpentByCategoryAndYear("groceries", "2020");
        Assert.assertEquals(2, expectedResult.size());
        Assert.assertEquals(10.4, expectedResult.get("highestAmount"), 0.1);
        Assert.assertEquals(5.99, expectedResult.get("lowestAmount"), 0.1);
    }

    @Test
    public void passesAnotherValidationForGetAmountSpentByCategoryAndYear() throws Exception {
        Map<String, Double> expectedResult = userTransactionsController.getAmountSpentByCategoryAndYear("MyMonthlyDD", "2020");
        Assert.assertEquals(2, expectedResult.size());
        Assert.assertEquals(600.00, expectedResult.get("highestAmount"), 0.1);
        Assert.assertEquals(40.00, expectedResult.get("lowestAmount"), 0.1);
    }

    @Test
    public void failValidationForGetAmountSpentByCategoryAndYearNullCheck() {
        Assertions.assertThrows(Exception.class, () -> {
            userTransactionsController.getAmountSpentByCategoryAndYear(null, null);
        });
    }

    @Test
    public void failValidationForGetAmountSpentByCategoryAndYearEmptyCheck() {
        Assertions.assertThrows(Exception.class, () -> {
            userTransactionsController.getAmountSpentByCategoryAndYear(" ", null);
        });
    }

    @Test
    public void failAnotherValidationForGetAmountSpentByCategoryAndYearEmptyCheck() {
        Assertions.assertThrows(Exception.class, () -> {
            userTransactionsController.getAmountSpentByCategoryAndYear(null, "");
        });
    }

}
