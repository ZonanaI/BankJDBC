package com.solvd.bankjdbc.services.myBatisImpl;

import com.solvd.bankjdbc.dao.ILoanDAO;
import com.solvd.bankjdbc.models.Loan;
import com.solvd.bankjdbc.services.ILoanService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Set;

public class LoanService implements ILoanService {

    private final static SqlSessionFactory sqlSessionFactory = MyBatisFactory.getSqlSessionFactory();
    @Override
    public void create(Loan loan) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            ILoanDAO loanDAO = session.getMapper(ILoanDAO.class);
            loanDAO.create(loan);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Loan getById(int id) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ILoanDAO loanDAO = session.getMapper(ILoanDAO.class);
            return loanDAO.getById(id);
        }
    }

    @Override
    public void update(Loan loan) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            ILoanDAO loanDAO = session.getMapper(ILoanDAO.class);
            loanDAO.update(loan);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public void remove(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            ILoanDAO loanDAO = session.getMapper(ILoanDAO.class);
            loanDAO.remove(id);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Set<Loan> getAll() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ILoanDAO loanDAO = session.getMapper(ILoanDAO.class);
            return loanDAO.getAll();
        }
    }

    @Override
    public Set<Loan> getByAccountId(int accountId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ILoanDAO loanDAO = session.getMapper(ILoanDAO.class);
            return loanDAO.getByAccountId(accountId);
        }
    }
}
