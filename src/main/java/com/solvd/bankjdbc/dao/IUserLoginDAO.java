package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.UserLogin;

import java.util.Set;

public interface IUserLoginDAO extends IBaseDao<UserLogin> {
    UserLogin getByUserName(String userName);
    Set<UserLogin> getByAccountId(int id);
}
