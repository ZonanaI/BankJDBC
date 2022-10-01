package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.UserSecurityQuestion;

import java.util.Set;

public interface IUserSecurityQuestionDAO extends IBaseDao<UserSecurityQuestion> {
    Set<UserSecurityQuestion> getByUserLoginId(int id);
}
