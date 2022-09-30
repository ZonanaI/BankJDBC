package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.FailedTransactionLog;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface IFailedTransactionLogDAO extends IBaseDao<FailedTransactionLog> {
    Set<FailedTransactionLog> getAll();
    Set<FailedTransactionLog> getByErrorDescription (String errorDescription);
    Set<FailedTransactionLog> getByDateTimeRange (LocalDateTime firstDateTime, LocalDateTime lastDateTime);
}
