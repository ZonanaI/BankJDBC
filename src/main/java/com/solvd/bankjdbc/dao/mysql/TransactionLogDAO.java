package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.ITransactionLogDAO;
import com.solvd.bankjdbc.models.TransactionLog;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionLogDAO extends AbstractMySQL implements ITransactionLogDAO {
    @Override
    public void create(TransactionLog object) {

    }

    @Override
    public TransactionLog getById(int id) {
        return null;
    }

    @Override
    public void update(TransactionLog object) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<TransactionLog> getAll() {
        return null;
    }

    @Override
    public List<TransactionLog> getByDateTimeRange(LocalDateTime firstDateTime, LocalDateTime lastDateTime) {
        return null;
    }

    @Override
    public List<TransactionLog> getByType(String type) {
        return null;
    }
}
