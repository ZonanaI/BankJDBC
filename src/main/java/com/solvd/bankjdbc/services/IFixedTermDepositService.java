package com.solvd.bankjdbc.services;

import com.solvd.bankjdbc.models.FixedTermDeposit;

import java.util.Set;

public interface IFixedTermDepositService extends IBaseService<FixedTermDeposit> {
    Set<FixedTermDeposit> getAll();
    Set<FixedTermDeposit> getByAccountId(int accountId);
}
