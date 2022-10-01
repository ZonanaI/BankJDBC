package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.Loan;

import java.util.List;
import java.util.Set;

public interface ILoanDAO extends IBaseDao<Loan> {
    Set<Loan> getByAccountId(int id);
    Set<Loan> getAll();
}
