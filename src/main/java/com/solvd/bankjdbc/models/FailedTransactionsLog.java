package com.solvd.bankjdbc.models;

import java.time.LocalDateTime;

public class FailedTransactionsLog {
    private long id;
    private LocalDateTime failedTransactionTime;
    private String errorDescription;

    //Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
