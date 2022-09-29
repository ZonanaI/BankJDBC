package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.Account;

import java.util.List;

public interface IAccountDAO extends IBaseDao<Account>{
    List<Account> getAll();
    List<Account> getByTypeId(int typeId);
    List<Account> getByStatusId(int statusId);
    Account getByAccountNumberId(int accountNumberId);
}
