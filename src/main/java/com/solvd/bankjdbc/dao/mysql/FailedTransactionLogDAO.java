package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.IFailedTransactionLogDAO;
import com.solvd.bankjdbc.models.FailedTransactionLog;

import java.time.LocalDateTime;
import java.util.List;

public class FailedTransactionLogDAO extends AbstractMySQL implements IFailedTransactionLogDAO {
    @Override
    public void create(FailedTransactionLog object) {

    }

    @Override
    public FailedTransactionLog getById(int id) {
        return null;
    }

    @Override
    public void update(FailedTransactionLog object) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<FailedTransactionLog> getAll() {
        return null;
    }

    @Override
    public List<FailedTransactionLog> getByErrorDescription(String errorDescription) {
        return null;
    }

    @Override
    public List<FailedTransactionLog> getByDateTimeRange(LocalDateTime firstDateTime, LocalDateTime lastDateTime) {
        return null;
    }
}
