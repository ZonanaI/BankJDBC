package com.solvd.bankjdbc.services.jdbcImpl;

import com.solvd.bankjdbc.dao.IAccountDAO;
import com.solvd.bankjdbc.dao.IUserLoginDAO;
import com.solvd.bankjdbc.dao.IUserSecurityQuestionDAO;
import com.solvd.bankjdbc.dao.mysql.AccountDAO;
import com.solvd.bankjdbc.dao.mysql.UserLoginDAO;
import com.solvd.bankjdbc.dao.mysql.UserSecurityQuestionDAO;
import com.solvd.bankjdbc.models.UserLogin;
import com.solvd.bankjdbc.services.IUserLoginService;

import java.util.Set;

public class UserLoginService implements IUserLoginService {

    private final IUserLoginDAO userLoginDAO = new UserLoginDAO();
    private final IUserSecurityQuestionDAO userSecurityQuestionDAO = new UserSecurityQuestionDAO();
    private final IAccountDAO accountDAO = new AccountDAO();
    @Override
    public void create(UserLogin userLogin) {
        userLoginDAO.create(userLogin);
    }
    @Override
    public UserLogin getById(int id) {
        UserLogin userLogin = userLoginDAO.getById(id);
        userLogin.setSecurityQuestionsSet(userSecurityQuestionDAO.getByUserLoginId(id));
        userLogin.setAccountSet(accountDAO.getByUserLoginId(id));
        return userLogin;
    }
    @Override
    public void update(UserLogin userLogin) {
        userLoginDAO.update(userLogin);
    }
    @Override
    public void remove(int id) {
        userLoginDAO.remove(id);
    }
    @Override
    public Set<UserLogin> getAll() {
        Set<com.solvd.bankjdbc.models.UserLogin> userLoginSet = userLoginDAO.getAll();
        for (com.solvd.bankjdbc.models.UserLogin userLogin:
                userLoginSet) {
            userLogin.setSecurityQuestionsSet(userSecurityQuestionDAO.getByUserLoginId(userLogin.getId()));
            userLogin.setAccountSet(accountDAO.getByUserLoginId(userLogin.getId()));
        }
        return userLoginSet;
    }
    @Override
    public UserLogin getByUserName(String userName) {
        UserLogin userLogin = userLoginDAO.getByUserName(userName);
        userLogin.setSecurityQuestionsSet(userSecurityQuestionDAO.getByUserLoginId(userLogin.getId()));
        userLogin.setAccountSet(accountDAO.getByUserLoginId(userLogin.getId()));
        return userLogin;
    }
    @Override
    public Set<UserLogin> getByAccountId(int id) {
        Set<UserLogin> userLoginSet = userLoginDAO.getByAccountId(id);
        for (UserLogin userLogin:
             userLoginSet) {
            userLogin.setSecurityQuestionsSet(userSecurityQuestionDAO.getByUserLoginId(userLogin.getId()));
            userLogin.setAccountSet(accountDAO.getByUserLoginId(userLogin.getId()));
        }
        return userLoginSet;
    }
}

