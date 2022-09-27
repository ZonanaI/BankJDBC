package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.UserSecurityQuestions;

import java.util.List;

public interface IUserSecurityQuestionsDAO extends IBaseDao<UserSecurityQuestions> {
    List<UserSecurityQuestions> getAll();
}
