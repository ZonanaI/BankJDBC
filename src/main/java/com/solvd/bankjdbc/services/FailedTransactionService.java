package com.solvd.bankjdbc.services;

import com.solvd.bankjdbc.dao.IFailedTransactionLogDAO;
import com.solvd.bankjdbc.dao.mysql.FailedTransactionLogDAO;
import com.solvd.bankjdbc.models.FailedTransactionLog;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<FailedTransactionLog> getAll() {
        return failedTransactionLogDAO.getAll();
    }

    public List<FailedTransactionLog> getByErrorType(String errorType) {
        return failedTransactionLogDAO.getByErrorType(errorType);
    }

    public List<FailedTransactionLog> getByDateTimeRange(LocalDateTime firstDateTime, LocalDateTime lastDateTime) {
        return failedTransactionLogDAO.getByDateTimeRange(firstDateTime, lastDateTime);
    }
}
