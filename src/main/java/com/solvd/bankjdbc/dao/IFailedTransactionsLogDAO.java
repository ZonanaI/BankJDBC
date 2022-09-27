package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.FailedTransactionsLog;

import java.time.LocalDateTime;
import java.util.List;

public interface IFailedTransactionsLogDAO extends IBaseDao<FailedTransactionsLog> {
    List<FailedTransactionsLog> getAll();
    List<FailedTransactionsLog> getByErrorDescription (String errorDescription);
    List<FailedTransactionsLog> getByDateTimeRange (LocalDateTime firstDateTime, LocalDateTime lastDateTime);
}
