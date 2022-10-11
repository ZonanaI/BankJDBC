package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.TransactionLog;

import java.time.LocalDateTime;
import java.util.Set;

public interface ITransactionLogDAO extends IBaseDAO<TransactionLog> {
    Set<TransactionLog> getAll();
    Set<TransactionLog> getByDateTimeRange(LocalDateTime firstDateTime, LocalDateTime lastDateTime);
    Set<TransactionLog> getByTypeId(int typeId);
    Set<TransactionLog> getByAccountId(int accountId);
}
