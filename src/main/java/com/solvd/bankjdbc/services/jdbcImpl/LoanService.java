package com.solvd.bankjdbc.services.jdbcImpl;

import com.solvd.bankjdbc.dao.ILoanDAO;
import com.solvd.bankjdbc.dao.mysql.LoanDAO;
import com.solvd.bankjdbc.models.Loan;
import com.solvd.bankjdbc.services.ILoanService;

import java.util.Set;

public class LoanService implements ILoanService {

    private final ILoanDAO loanDAO = new LoanDAO();
    @Override
    public void create(Loan loan) {
        loanDAO.create(loan);
    }
    @Override
    public Loan getById(int id) {
        return loanDAO.getById(id);
    }
    @Override
    public void update(Loan loan) {
        loanDAO.update(loan);
    }
    @Override
    public void remove(int id) {
        loanDAO.remove(id);
    }
    @Override
    public Set<Loan> getAll() {
        return loanDAO.getAll();
    }
    @Override
    public Set<Loan> getByAccountId(int accountId) {
        return loanDAO.getByAccountId(accountId);
    }
}
