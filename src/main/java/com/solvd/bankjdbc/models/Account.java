package com.solvd.bankjdbc.models;

import java.math.BigDecimal;
import java.util.Set;

public class Account {
    private int id;
    private int accountTypeID;
    private int accountStatusID;
    private int accountNumberID;

    private Set<Integer> customerIds;
    private Set<Integer> userLoginIds;
    private Set<Integer> carIds;
    private Set<Integer> loanIds;
    private Set<Integer> fixedTermDepositIds;
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

    public Set<Integer> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(Set<Integer> customerIds) {
        this.customerIds = customerIds;
    }

    public Set<Integer> getUserLoginIds() {
        return userLoginIds;
    }

    public void setUserLoginIds(Set<Integer> userLoginIds) {
        this.userLoginIds = userLoginIds;
    }

    public Set<Integer> getCarIds() {
        return carIds;
    }

    public void setCarIds(Set<Integer> carIds) {
        this.carIds = carIds;
    }

    public Set<Integer> getLoanIds() {
        return loanIds;
    }

    public void setLoanIds(Set<Integer> loanIds) {
        this.loanIds = loanIds;
    }

    public Set<Integer> getFixedTermDepositIds() {
        return fixedTermDepositIds;
    }

    public void setFixedTermDepositIds(Set<Integer> fixedTermDepositIds) {
        this.fixedTermDepositIds = fixedTermDepositIds;
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
}
