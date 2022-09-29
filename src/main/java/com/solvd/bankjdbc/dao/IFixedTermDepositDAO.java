package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.FixedTermDeposit;

import java.util.List;

public interface IFixedTermDepositDAO extends IBaseDao<FixedTermDeposit> {
    List<FixedTermDeposit> getAll();
}
