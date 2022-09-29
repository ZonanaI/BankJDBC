package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.FailedTransactionLog;

import java.time.LocalDateTime;
import java.util.List;

public interface IFailedTransactionLogDAO extends IBaseDao<FailedTransactionLog> {
    List<FailedTransactionLog> getAll();
    List<FailedTransactionLog> getByErrorDescription (String errorDescription);
    List<FailedTransactionLog> getByDateTimeRange (LocalDateTime firstDateTime, LocalDateTime lastDateTime);
}
