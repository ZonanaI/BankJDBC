package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.ITransactionTypeDAO;
import com.solvd.bankjdbc.models.TransactionType;

public class TransactionTypeDAO extends AbstractMySQL implements ITransactionTypeDAO {
    @Override
    public void create(TransactionType object) {

    }

    @Override
    public TransactionType getById(int id) {
        return null;
    }

    @Override
    public void update(TransactionType object) {

    }

    @Override
    public void remove(int id) {

    }
}
