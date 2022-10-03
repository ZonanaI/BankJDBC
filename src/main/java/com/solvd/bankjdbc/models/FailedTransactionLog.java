package com.solvd.bankjdbc.models;

import java.time.LocalDateTime;

public class FailedTransactionLog implements Comparable<FailedTransactionLog> {
    private int id;
    private int failedTransactionErrorTypeId;
    private LocalDateTime failedTransactionTime;
    private String errorType;

    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFailedTransactionErrorTypeId() {
        return failedTransactionErrorTypeId;
    }

    public void setFailedTransactionErrorTypeId(int failedTransactionErrorTypeId) {
        this.failedTransactionErrorTypeId = failedTransactionErrorTypeId;
    }

    public LocalDateTime getFailedTransactionTime() {
        return failedTransactionTime;
    }

    public void setFailedTransactionTime(LocalDateTime failedTransactionTime) {
        this.failedTransactionTime = failedTransactionTime;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    @Override
    public String toString() {
        return "FailedTransactionLog{" +
                "id=" + id +
                ", failedTransactionErrorTypeId=" + failedTransactionErrorTypeId +
                ", failedTransactionTime=" + failedTransactionTime +
                ", errorType='" + errorType + '\'' +
                '}';
    }

    @Override
    public int compareTo(FailedTransactionLog other) {
        return Integer.compare(this.id,other.id);
    }
}
