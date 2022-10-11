package com.solvd.bankjdbc.services.jdbcImpl;

import com.solvd.bankjdbc.dao.IFailedTransactionLogDAO;
import com.solvd.bankjdbc.dao.mysql.FailedTransactionLogDAO;
import com.solvd.bankjdbc.models.FailedTransactionLog;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class FailedTransactionService {

    private final IFailedTransactionLogDAO failedTransactionLogDAO = new FailedTransactionLogDAO();

    public void create(FailedTransactionLog failedTransactionLog) {
        failedTransactionLogDAO.create(failedTransactionLog);
    }

    public FailedTransactionLog getById(int id) {
        return failedTransactionLogDAO.getById(id);
    }

    public void update(FailedTransactionLog failedTransactionLog) {
        failedTransactionLogDAO.update(failedTransactionLog);
    }

    public void remove(int id) {
        failedTransactionLogDAO.remove(id);
    }

    public Set<FailedTransactionLog> getAll() {
        return failedTransactionLogDAO.getAll();
    }

    public Set<FailedTransactionLog> getByErrorType(String errorType) {
        return failedTransactionLogDAO.getByErrorType(errorType);
    }

    public Set<FailedTransactionLog> getByDateTimeRange(LocalDateTime firstDateTime, LocalDateTime lastDateTime) {
        return failedTransactionLogDAO.getByDateTimeRange(firstDateTime, lastDateTime);
    }
}
