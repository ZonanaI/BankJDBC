package com.solvd.bankjdbc.services.myBatisImpl;

import com.solvd.bankjdbc.dao.IUserLoginDAO;
import com.solvd.bankjdbc.dao.IUserSecurityQuestionDAO;
import com.solvd.bankjdbc.models.UserLogin;
import com.solvd.bankjdbc.services.IUserLoginService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Set;

public class UserLoginService implements IUserLoginService {

    private final static SqlSessionFactory sqlSessionFactory = MyBatisFactory.getSqlSessionFactory();
    @Override
    public void create(UserLogin userLogin) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IUserLoginDAO userLoginDAO = session.getMapper(IUserLoginDAO.class);
            userLoginDAO.create(userLogin);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public UserLogin getById(int id) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IUserLoginDAO userLoginDAO = session.getMapper(IUserLoginDAO.class);
            UserLogin userLogin = userLoginDAO.getById(id);
            IUserSecurityQuestionDAO userSecurityQuestionDAO = session.getMapper(IUserSecurityQuestionDAO.class);
            userLogin.setSecurityQuestionsSet(userSecurityQuestionDAO.getByUserLoginId(userLogin.getId()));
            return userLogin;
        }
    }

    @Override
    public void update(UserLogin userLogin) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IUserLoginDAO userLoginDAO = session.getMapper(IUserLoginDAO.class);
            userLoginDAO.update(userLogin);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public void remove(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IUserLoginDAO userLoginDAO = session.getMapper(IUserLoginDAO.class);
            userLoginDAO.remove(id);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public UserLogin getByUserName(String userName) {
        return null;
    }

    @Override
    public Set<UserLogin> getAll() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IUserLoginDAO userLoginDAO = session.getMapper(IUserLoginDAO.class);
            Set<UserLogin> userLoginSet = userLoginDAO.getAll();
            IUserSecurityQuestionDAO userSecurityQuestionDAO = session.getMapper(IUserSecurityQuestionDAO.class);
            userLoginSet.forEach(t -> t.setSecurityQuestionsSet(userSecurityQuestionDAO.getByUserLoginId(t.getId())));
            return userLoginSet;
        }
    }

    @Override
    public Set<UserLogin> getByAccountId(int accountId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IUserLoginDAO userLoginDAO = session.getMapper(IUserLoginDAO.class);
            Set<UserLogin> userLoginSet = userLoginDAO.getByAccountId(accountId);
            IUserSecurityQuestionDAO userSecurityQuestionDAO = session.getMapper(IUserSecurityQuestionDAO.class);
            userLoginSet.forEach(t -> t.setSecurityQuestionsSet(userSecurityQuestionDAO.getByUserLoginId(t.getId())));
            return userLoginSet;
        }    
    }
}
