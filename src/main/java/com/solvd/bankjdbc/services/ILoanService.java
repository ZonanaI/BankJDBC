package com.solvd.bankjdbc.services;

import com.solvd.bankjdbc.models.Loan;

import java.util.Set;

public interface ILoanService extends IBaseService<Loan> {
    Set<Loan> getAll();
    Set<Loan> getByAccountId(int accountId);
}
