package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.FailedTransactionLog;

import java.time.LocalDateTime;
import java.util.Set;

public interface IFailedTransactionLogDAO extends IBaseDAO<FailedTransactionLog> {
    Set<FailedTransactionLog> getAll();
    Set<FailedTransactionLog> getByErrorType(String errorType);
    Set<FailedTransactionLog> getByDateTimeRange (LocalDateTime firstDateTime, LocalDateTime lastDateTime);
}
