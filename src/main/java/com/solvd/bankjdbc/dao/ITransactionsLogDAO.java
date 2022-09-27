package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.TransactionsLog;

import java.time.LocalDateTime;
import java.util.List;

public interface ITransactionsLogDAO extends IBaseDao<TransactionsLog> {
    List<TransactionsLog> getAll();
    List<TransactionsLog> getByDateTimeRange(LocalDateTime firstDateTime, LocalDateTime lastDateTime);
    List<TransactionsLog> getByType(String type);
}
