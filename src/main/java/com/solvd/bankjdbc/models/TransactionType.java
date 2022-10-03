package com.solvd.bankjdbc.models;

import java.math.BigDecimal;

public class TransactionType {

    private int id;
    private String name;
    private BigDecimal feeAmount;
    private String description;

    //Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TransactionType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", feeAmount=" + feeAmount +
                ", description='" + description + '\'' +
                '}';
    }
}
