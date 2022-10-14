package com.solvd.bankjdbc.services;

import com.solvd.bankjdbc.models.UserLogin;

import java.util.Set;

public interface IUserLoginService extends IBaseService<UserLogin> {
    UserLogin getByUserName(String userName);
    Set<UserLogin> getAll();
    Set<UserLogin> getByAccountId(int id);
}
