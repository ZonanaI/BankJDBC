package com.solvd.bankjdbc.models;

import java.math.BigDecimal;
import java.util.Set;

public class Accounts {
    private long id;
    private BigDecimal balance;
    private String accountType;
    private String accountStatus;
    private String accountNumber;
    private Set<Customers> customersSet;
    private Set<UsersLogin> usersLoginSet;
    private Set<Cards> cardsSet;
    private Set<Loans> loansSet;
    private Set<FixedTermDeposits> fixedTermDepositsSet;
    //Getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<Customers> getCustomersSet() {
        return customersSet;
    }

    public void setCustomersSet(Set<Customers> customersSet) {
        this.customersSet = customersSet;
    }

    public Set<UsersLogin> getUsersLoginSet() {
        return usersLoginSet;
    }

    public void setUsersLoginSet(Set<UsersLogin> usersLoginSet) {
        this.usersLoginSet = usersLoginSet;
    }

    public Set<Cards> getCardsSet() {
        return cardsSet;
    }

    public void setCardsSet(Set<Cards> cardsSet) {
        this.cardsSet = cardsSet;
    }

    public Set<Loans> getLoansSet() {
        return loansSet;
    }

    public void setLoansSet(Set<Loans> loansSet) {
        this.loansSet = loansSet;
    }

    public Set<FixedTermDeposits> getFixedTermDepositsSet() {
        return fixedTermDepositsSet;
    }

    public void setFixedTermDepositsSet(Set<FixedTermDeposits> fixedTermDepositsSet) {
        this.fixedTermDepositsSet = fixedTermDepositsSet;
    }
}
