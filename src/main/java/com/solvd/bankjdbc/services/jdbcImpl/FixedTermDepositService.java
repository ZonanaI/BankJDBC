package com.solvd.bankjdbc.services.jdbcImpl;

import com.solvd.bankjdbc.dao.IFixedTermDepositDAO;
import com.solvd.bankjdbc.dao.mysql.FixedTermDepositDAO;
import com.solvd.bankjdbc.models.FixedTermDeposit;
import com.solvd.bankjdbc.services.IFixedTermDepositService;

import java.util.Set;

public class FixedTermDepositService implements IFixedTermDepositService {
    private final IFixedTermDepositDAO fixedTermDepositDAO = new FixedTermDepositDAO();
    @Override
    public void create(FixedTermDeposit fixedTermDeposit) {
        fixedTermDepositDAO.create(fixedTermDeposit);
    }
    @Override
    public FixedTermDeposit getById(int id) {
        return fixedTermDepositDAO.getById(id);
    }
    @Override
    public void update(FixedTermDeposit fixedTermDeposit) {
        fixedTermDepositDAO.update(fixedTermDeposit);
    }
    @Override
    public void remove(int id) {
        fixedTermDepositDAO.remove(id);
    }
    @Override
    public Set<FixedTermDeposit> getAll() {
        return fixedTermDepositDAO.getAll();
    }
    @Override
    public Set<FixedTermDeposit> getByAccountId(int accountId) {
        return fixedTermDepositDAO.getByAccountId(accountId);
    }
}
