package com.solvd.bankjdbc.services.myBatisImpl;

import com.solvd.bankjdbc.dao.IUserSecurityQuestionDAO;
import com.solvd.bankjdbc.models.UserSecurityQuestion;
import com.solvd.bankjdbc.services.IUserSecurityQuestionService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Set;

public class UserSecurityQuestionService implements IUserSecurityQuestionService {

    private final static SqlSessionFactory sqlSessionFactory = MyBatisFactory.getSqlSessionFactory();

    @Override
    public void create(UserSecurityQuestion userSecurityQuestion) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IUserSecurityQuestionDAO userSecurityQuestionDAO = session.getMapper(IUserSecurityQuestionDAO.class);
            userSecurityQuestionDAO.create(userSecurityQuestion);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public UserSecurityQuestion getById(int id) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IUserSecurityQuestionDAO userSecurityQuestionDAO = session.getMapper(IUserSecurityQuestionDAO.class);
            return userSecurityQuestionDAO.getById(id);
        }
    }

    @Override
    public void update(UserSecurityQuestion userSecurityQuestion) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IUserSecurityQuestionDAO userSecurityQuestionDAO = session.getMapper(IUserSecurityQuestionDAO.class);
            userSecurityQuestionDAO.update(userSecurityQuestion);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public void remove(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IUserSecurityQuestionDAO userSecurityQuestionDAO = session.getMapper(IUserSecurityQuestionDAO.class);
            userSecurityQuestionDAO.remove(id);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Set<UserSecurityQuestion> getByUserLoginId(int id) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IUserSecurityQuestionDAO userSecurityQuestionDAO = session.getMapper(IUserSecurityQuestionDAO.class);
            return userSecurityQuestionDAO.getByUserLoginId(id);
        }
    }
}
