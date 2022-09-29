package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.Loan;

import java.util.List;

public interface ILoanDAO extends IBaseDao<Loan> {
    List<Loan> getAll();
}
