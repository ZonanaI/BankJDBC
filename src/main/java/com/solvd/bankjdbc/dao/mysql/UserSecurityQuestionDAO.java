package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.IUserSecurityQuestionDAO;
import com.solvd.bankjdbc.models.UserSecurityQuestion;

import java.util.List;

public class UserSecurityQuestionDAO extends AbstractMySQL implements IUserSecurityQuestionDAO {
    @Override
    public void create(UserSecurityQuestion object) {

    }

    @Override
    public UserSecurityQuestion getById(int id) {
        return null;
    }

    @Override
    public void update(UserSecurityQuestion object) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<UserSecurityQuestion> getAll() {
        return null;
    }
}
