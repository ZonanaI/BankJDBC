package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.Loans;

import java.util.List;

public interface ILoansDAO extends IBaseDao<Loans> {
    List<Loans> getAll();
}
