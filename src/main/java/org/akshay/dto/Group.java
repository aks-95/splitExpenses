package org.akshay.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Group {
    int id;
    String name;
    List<User> users;
    List<Transaction>transactions;
    List<BalanceAmount> balanceAmounts;

    Group(int id, User user,  String name){
        this.id = id;
        this.users = new ArrayList<>();
        this.users.add(user);
        this.name = name;
        this.balanceAmounts = new ArrayList<>();
        this.transactions  = new ArrayList<>();
    }
    public Transaction addTransaction(User user, double amount,List<SplitAmount>splitAmounts, String description){
        Transaction transaction = new Transaction(user,amount,splitAmounts,description,System.currentTimeMillis());
        this.transactions.add(transaction);
        return transaction;
    }
    public User addUser(User user){
       this.users.add(user);
       return  user;
    }
}
