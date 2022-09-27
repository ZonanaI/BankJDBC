package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.Accounts;

import java.util.List;

public interface IAccountsDAO extends IBaseDao<Accounts>{
    List<Accounts> getAll();
    List<Accounts> getByType(String type);
    List<Accounts> getByStatus(String status);
    Accounts getByAccountNumber(long accountNumber);
}
