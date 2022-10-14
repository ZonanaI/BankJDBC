package com.solvd.bankjdbc.services;

import com.solvd.bankjdbc.models.Account;

import java.util.Set;

public interface IAccountService extends IBaseService<Account> {
    Set<Account> getAll();
    Set<Account> getByTypeId(int typeId);
    Set<Account> getByStatusId(int statusId);
    Set<Account> getByCustomerId (int customerId);
    Set<Account> getByUserLoginId (int userLoginId);
    Account getByAccountNumberId(int accountNumberId);
}
