package org.akshay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Transaction {
    User user;
    double transactionAmount;
    List<SplitAmount>splitAmounts;
    String description;
    long transactionTimeMillis;
}
