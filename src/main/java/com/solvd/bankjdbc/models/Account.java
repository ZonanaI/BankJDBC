package com.solvd.bankjdbc.models;

import java.math.BigDecimal;
import java.util.Set;

public class Account implements Comparable<Account>{
    private int id;
    private int accountTypeID;
    private int accountStatusID;
    private int accountNumberID;
    private BigDecimal balance;
    private String accountType;
    private String accountStatus;
    private String accountNumber;
    private Set<Customer> customerSet;
    private Set<UserLogin> userLoginSet;
    private Set<Card> cardSet;
    private Set<Loan> loanSet;
    private Set<FixedTermDeposit> fixedTermDepositSet;
    //Getters and setters
    private Set<TransactionLog> transactionLogSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(int accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public int getAccountStatusID() {
        return accountStatusID;
    }

    public void setAccountStatusID(int accountStatusID) {
        this.accountStatusID = accountStatusID;
    }

    public int getAccountNumberID() {
        return accountNumberID;
    }

    public void setAccountNumberID(int accountNumberID) {
        this.accountNumberID = accountNumberID;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }

    public Set<UserLogin> getUserLoginSet() {
        return userLoginSet;
    }

    public void setUserLoginSet(Set<UserLogin> userLoginSet) {
        this.userLoginSet = userLoginSet;
    }

    public Set<Card> getCardSet() {
        return cardSet;
    }

    public void setCardSet(Set<Card> cardSet) {
        this.cardSet = cardSet;
    }

    public Set<Loan> getLoanSet() {
        return loanSet;
    }

    public void setLoanSet(Set<Loan> loanSet) {
        this.loanSet = loanSet;
    }

    public Set<FixedTermDeposit> getFixedTermDepositSet() {
        return fixedTermDepositSet;
    }

    public void setFixedTermDepositSet(Set<FixedTermDeposit> fixedTermDepositSet) {
        this.fixedTermDepositSet = fixedTermDepositSet;
    }

    public Set<TransactionLog> getTransactionLogSet() {
        return transactionLogSet;
    }

    public void setTransactionLogSet(Set<TransactionLog> transactionLogSet) {
        this.transactionLogSet = transactionLogSet;
    }

    @Override
    public int compareTo(Account other) {
        return Integer.compare(this.id,other.id);
    }
}
