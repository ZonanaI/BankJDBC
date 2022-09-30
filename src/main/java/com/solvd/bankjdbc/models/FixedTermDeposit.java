package com.solvd.bankjdbc.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FixedTermDeposit implements Comparable <FixedTermDeposit> {
    private int id;
    private BigDecimal amount;
    private BigDecimal rate;
    private LocalDate fromDate;

    //Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }
    @Override
    public int compareTo(FixedTermDeposit other) {
        return Integer.compare(this.id,other.id);
    }
}
