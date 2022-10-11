package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.FixedTermDeposit;

import java.util.Set;

public interface IFixedTermDepositDAO extends IBaseDAO<FixedTermDeposit> {
    Set<FixedTermDeposit> getAll();
    Set<FixedTermDeposit> getByAccountId(int id);
}
