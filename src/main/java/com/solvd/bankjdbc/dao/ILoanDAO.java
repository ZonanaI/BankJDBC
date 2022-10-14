package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.Loan;

import java.util.Set;

public interface ILoanDAO extends IBaseDAO<Loan> {
    Set<Loan> getByAccountId(int accountId);
    Set<Loan> getAll();
}
