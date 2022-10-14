package com.solvd.bankjdbc.services;

import com.solvd.bankjdbc.models.UserSecurityQuestion;

import java.util.Set;

public interface IUserSecurityQuestionService extends IBaseService<UserSecurityQuestion> {
    Set<UserSecurityQuestion> getByUserLoginId(int id);
}
