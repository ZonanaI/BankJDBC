package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.ILoanDAO;
import com.solvd.bankjdbc.models.Loan;

import java.util.List;

public class LoanDAO extends AbstractMySQL implements ILoanDAO {
    @Override
    public void create(Loan object) {

    }

    @Override
    public Loan getById(int id) {
        return null;
    }

    @Override
    public void update(Loan object) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Loan> getAll() {
        return null;
    }
}
