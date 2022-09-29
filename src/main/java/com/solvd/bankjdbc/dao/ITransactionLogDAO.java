package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.TransactionLog;

import java.time.LocalDateTime;
import java.util.List;

public interface ITransactionLogDAO extends IBaseDao<TransactionLog> {
    List<TransactionLog> getAll();
    List<TransactionLog> getByDateTimeRange(LocalDateTime firstDateTime, LocalDateTime lastDateTime);
    List<TransactionLog> getByType(String type);
}
