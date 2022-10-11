package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.UserSecurityQuestion;

import java.util.Set;

public interface IUserSecurityQuestionDAO extends IBaseDAO<UserSecurityQuestion> {
    Set<UserSecurityQuestion> getByUserLoginId(int id);
}
