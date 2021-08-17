package com.example.internetbanking.service.ServiceImpl;

import com.example.internetbanking.model.UserTransactions;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UserTransactionsServiceImpl {

    public List<UserTransactions> getAllUserTransactionsByCategory(String category) throws Exception;

    public Map<String, Double> getAmountSpentByCategoryAndYear(@Param("category") String category,
                                                                      @Param("year") String year) throws Exception;

    public double getTotalOutgoingPerCategory(String category) throws Exception;

    public List<Map<String, Double>> getMonthlyAverageSpendPerCategory(String category) throws Exception;

}
