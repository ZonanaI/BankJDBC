package com.solvd.bankjdbc.services.jdbcImpl;

import com.solvd.bankjdbc.dao.ILoanDAO;
import com.solvd.bankjdbc.dao.mysql.LoanDAO;
import com.solvd.bankjdbc.models.Loan;

import java.util.Set;

public class LoanService {

    private final ILoanDAO loanDAO = new LoanDAO();

    public void create(Loan loan) {
        loanDAO.create(loan);
    }

    public Loan getById(int id) {
        return loanDAO.getById(id);
    }

    public void update(Loan loan) {
        loanDAO.update(loan);
    }

    public void remove(int id) {
        loanDAO.remove(id);
    }

    public Set<Loan> getAll() {
        return loanDAO.getAll();
    }

    public Set<Loan> getByAccountId(int id) {
        return loanDAO.getByAccountId(id);
    }
}
