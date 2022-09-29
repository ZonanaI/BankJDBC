package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.IUserLoginDAO;
import com.solvd.bankjdbc.models.UserLogin;

public class UserLoginDAO extends AbstractMySQL implements IUserLoginDAO {
    @Override
    public void create(UserLogin object) {

    }

    @Override
    public UserLogin getById(int id) {
        return null;
    }

    @Override
    public void update(UserLogin object) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public UserLogin getByUserName(String username) {
        return null;
    }
}
