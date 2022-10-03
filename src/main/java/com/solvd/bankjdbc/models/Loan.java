package com.solvd.bankjdbc.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Loan implements Comparable<Loan> {
    private int id;
    private int accountId;
    private BigDecimal amount;
    private BigDecimal rate;
    private BigDecimal returnedAmount;
    private LocalDate fromDate;

    //Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getReturnedAmount() {
        return returnedAmount;
    }

    public void setReturnedAmount(BigDecimal returnedAmount) {
        this.returnedAmount = returnedAmount;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }
    @Override
    public int compareTo(Loan other) {
        return Integer.compare(this.id,other.id);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", amount=" + amount +
                ", rate=" + rate +
                ", returnedAmount=" + returnedAmount +
                ", fromDate=" + fromDate +
                '}';
    }
}
