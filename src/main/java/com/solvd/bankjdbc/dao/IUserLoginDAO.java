package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.UserLogin;

public interface IUserLoginDAO extends IBaseDao<UserLogin> {
    UserLogin getByUserName(String username);
}
