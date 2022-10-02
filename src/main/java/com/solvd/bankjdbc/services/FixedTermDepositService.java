package com.solvd.bankjdbc.services;

import com.solvd.bankjdbc.dao.IFixedTermDepositDAO;
import com.solvd.bankjdbc.dao.mysql.FixedTermDepositDAO;
import com.solvd.bankjdbc.models.FixedTermDeposit;

import java.util.Set;

public class FixedTermDepositService {
    private final IFixedTermDepositDAO fixedTermDepositDAO = new FixedTermDepositDAO();

    public void create(FixedTermDeposit fixedTermDeposit) {
        fixedTermDepositDAO.create(fixedTermDeposit);
    }

    public FixedTermDeposit getById(int id) {
        return fixedTermDepositDAO.getById(id);
    }

    public void update(FixedTermDeposit fixedTermDeposit) {
        fixedTermDepositDAO.update(fixedTermDeposit);
    }

    public void remove(int id) {
        fixedTermDepositDAO.remove(id);
    }

    public Set<FixedTermDeposit> getAll() {
        return fixedTermDepositDAO.getAll();
    }

    public Set<FixedTermDeposit> getByAccountId(int id) {
        return fixedTermDepositDAO.getByAccountId(id);
    }
}
