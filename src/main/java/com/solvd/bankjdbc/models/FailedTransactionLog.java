package com.solvd.bankjdbc.models;

import java.time.LocalDateTime;

public class FailedTransactionLog {
    private int id;
    private LocalDateTime failedTransactionTime;
    private String errorDescription;

    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFailedTransactionTime() {
        return failedTransactionTime;
    }

    public void setFailedTransactionTime(LocalDateTime failedTransactionTime) {
        this.failedTransactionTime = failedTransactionTime;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
