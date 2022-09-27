package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.UsersLogin;

public interface IUsersLoginDAO extends IBaseDao<UsersLogin> {
    UsersLogin getByUserName(String username);
}
