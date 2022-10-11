package com.solvd.bankjdbc.services.myBatisImpl;

import com.solvd.bankjdbc.dao.IFixedTermDepositDAO;
import com.solvd.bankjdbc.models.FixedTermDeposit;
import com.solvd.bankjdbc.services.IFixedTermDepositService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Set;

public class FixedTermDepositService implements IFixedTermDepositService {

    private final static SqlSessionFactory sqlSessionFactory = MyBatisFactory.getSqlSessionFactory();
    @Override
    public void create(FixedTermDeposit fixedTermDeposit) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IFixedTermDepositDAO fixedTermDepositDAO = session.getMapper(IFixedTermDepositDAO.class);
            fixedTermDepositDAO.create(fixedTermDeposit);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public FixedTermDeposit getById(int id) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IFixedTermDepositDAO fixedTermDepositDAO = session.getMapper(IFixedTermDepositDAO.class);
            return fixedTermDepositDAO.getById(id);
        }
    }

    @Override
    public void update(FixedTermDeposit fixedTermDeposit) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IFixedTermDepositDAO fixedTermDepositDAO = session.getMapper(IFixedTermDepositDAO.class);
            fixedTermDepositDAO.update(fixedTermDeposit);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public void remove(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IFixedTermDepositDAO fixedTermDepositDAO = session.getMapper(IFixedTermDepositDAO.class);
            fixedTermDepositDAO.remove(id);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Set<FixedTermDeposit> getAll() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IFixedTermDepositDAO fixedTermDepositDAO = session.getMapper(IFixedTermDepositDAO.class);
            return fixedTermDepositDAO.getAll();
        }
    }

    @Override
    public Set<FixedTermDeposit> getByAccountId(int accountId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IFixedTermDepositDAO fixedTermDepositDAO = session.getMapper(IFixedTermDepositDAO.class);
            return fixedTermDepositDAO.getByAccountId(accountId);
        }
    }
}
