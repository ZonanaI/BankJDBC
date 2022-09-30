package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.FixedTermDeposit;

import java.util.List;
import java.util.Set;

public interface IFixedTermDepositDAO extends IBaseDao<FixedTermDeposit> {
    Set<FixedTermDeposit> getByAccountId();
}
