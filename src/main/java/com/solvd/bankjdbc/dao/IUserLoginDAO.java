package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.UserLogin;

import java.util.Set;

public interface IUserLoginDAO extends IBaseDAO<UserLogin> {
    UserLogin getByUserName(String userName);
    Set<UserLogin> getAll();
    Set<UserLogin> getByAccountId(int id);
}
