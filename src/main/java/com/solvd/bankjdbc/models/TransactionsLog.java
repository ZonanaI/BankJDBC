package com.solvd.bankjdbc.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionsLog {

    private long id;
    private LocalDateTime transactionDate;
    private BigDecimal transactionAmount;
    private BigDecimal newBalance;
    private Employees employee;
    private Accounts account;
    private TransactionsType transactionType;

    //Getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(BigDecimal newBalance) {
        this.newBalance = newBalance;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    public TransactionsType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionsType transactionType) {
        this.transactionType = transactionType;
    }
}
