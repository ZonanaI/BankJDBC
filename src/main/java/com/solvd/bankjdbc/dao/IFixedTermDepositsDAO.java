package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.FixedTermDeposits;

import java.util.List;

public interface IFixedTermDepositsDAO extends IBaseDao<FixedTermDeposits> {
    List<FixedTermDeposits> getAll();
}
