package com.solvd.bankjdbc.services.myBatisImpl;

import com.solvd.bankjdbc.dao.ITransactionTypeDAO;
import com.solvd.bankjdbc.models.TransactionType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TransactionTypeService implements ITransactionTypeDAO {

    private final static SqlSessionFactory sqlSessionFactory = MyBatisFactory.getSqlSessionFactory();
    @Override
    public void create(TransactionType transactionType) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            ITransactionTypeDAO transactionTypeDAO = session.getMapper(ITransactionTypeDAO.class);
            transactionTypeDAO.create(transactionType);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public TransactionType getById(int id) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ITransactionTypeDAO transactionTypeDAO = session.getMapper(ITransactionTypeDAO.class);
            return transactionTypeDAO.getById(id);
        }
    }

    @Override
    public void update(TransactionType transactionType) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            ITransactionTypeDAO transactionTypeDAO = session.getMapper(ITransactionTypeDAO.class);
            transactionTypeDAO.update(transactionType);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public void remove(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            ITransactionTypeDAO transactionTypeDAO = session.getMapper(ITransactionTypeDAO.class);
        transactionTypeDAO.remove(id);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }
}
