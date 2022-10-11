package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.Account;



import java.util.Set;

public interface IAccountDAO extends IBaseDAO<Account> {
    Set<Account> getAll();
    Set<Account> getByTypeId(int typeId);
    Set<Account> getByStatusId(int statusId);
    Set<Account> getByCustomerId (int customerId);
    Set<Account> getByUserLoginId (int userLoginId);
    Account getByAccountNumberId(int accountNumberId);
}
