package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.UserSecurityQuestion;

import java.util.List;

public interface IUserSecurityQuestionDAO extends IBaseDao<UserSecurityQuestion> {
    List<UserSecurityQuestion> getAll();
}
