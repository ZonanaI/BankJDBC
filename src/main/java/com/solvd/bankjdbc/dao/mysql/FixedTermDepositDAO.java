package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.IFixedTermDepositDAO;
import com.solvd.bankjdbc.models.FixedTermDeposit;

import java.util.List;

public class FixedTermDepositDAO extends AbstractMySQL implements IFixedTermDepositDAO {
    @Override
    public void create(FixedTermDeposit object) {

    }

    @Override
    public FixedTermDeposit getById(int id) {
        return null;
    }

    @Override
    public void update(FixedTermDeposit object) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<FixedTermDeposit> getAll() {
        return null;
    }
}
