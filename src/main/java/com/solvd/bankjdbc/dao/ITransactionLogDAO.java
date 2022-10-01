package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.TransactionLog;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface ITransactionLogDAO extends IBaseDao<TransactionLog> {
    Set<TransactionLog> getAll();
    Set<TransactionLog> getByDateTimeRange(LocalDateTime firstDateTime, LocalDateTime lastDateTime);
    Set<TransactionLog> getByTypeId(int typeId);
    Set<TransactionLog> getByAccountId(int accountId);
}
