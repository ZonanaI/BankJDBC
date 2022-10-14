package com.solvd.bankjdbc.services.myBatisImpl;

import com.solvd.bankjdbc.dao.ITransactionLogDAO;
import com.solvd.bankjdbc.dao.ITransactionTypeDAO;
import com.solvd.bankjdbc.models.TransactionLog;
import com.solvd.bankjdbc.services.ITransactionLogService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.time.LocalDateTime;
import java.util.Set;

public class TransactionLogService implements ITransactionLogService {

    private final static SqlSessionFactory sqlSessionFactory = MyBatisFactory.getSqlSessionFactory();
    @Override
    public void create(TransactionLog transactionLog) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            ITransactionLogDAO transactionLogDAO = session.getMapper(ITransactionLogDAO.class);
            transactionLogDAO.create(transactionLog);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public TransactionLog getById(int id) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ITransactionLogDAO transactionLogDAO = session.getMapper(ITransactionLogDAO.class);
            TransactionLog transactionLog = transactionLogDAO.getById(id);
            ITransactionTypeDAO transactionTypeDAO = session.getMapper(ITransactionTypeDAO.class);
            transactionLog.setTransactionType(transactionTypeDAO.getById(transactionLog.getTransactionTypeId()));
            return transactionLog;
        }
    }

    @Override
    public void update(TransactionLog transactionLog) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            ITransactionLogDAO transactionLogDAO = session.getMapper(ITransactionLogDAO.class);
            transactionLogDAO.update(transactionLog);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public void remove(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            ITransactionLogDAO transactionLogDAO = session.getMapper(ITransactionLogDAO.class);
            transactionLogDAO.remove(id);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Set<TransactionLog> getAll() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ITransactionLogDAO transactionLogDAO = session.getMapper(ITransactionLogDAO.class);
            Set<TransactionLog> transactionLogSet = transactionLogDAO.getAll();
            ITransactionTypeDAO transactionTypeDAO = session.getMapper(ITransactionTypeDAO.class);
            transactionLogSet.forEach(t -> t.setTransactionType(transactionTypeDAO.getById(t.getTransactionTypeId())));
            return transactionLogSet;
        }
    }

    @Override
    public Set<TransactionLog> getByDateTimeRange(LocalDateTime firstDateTime, LocalDateTime lastDateTime) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ITransactionLogDAO transactionLogDAO = session.getMapper(ITransactionLogDAO.class);
            Set<TransactionLog> transactionLogSet = transactionLogDAO.getByDateTimeRange(firstDateTime, lastDateTime);
            ITransactionTypeDAO transactionTypeDAO = session.getMapper(ITransactionTypeDAO.class);
            transactionLogSet.forEach(t -> t.setTransactionType(transactionTypeDAO.getById(t.getTransactionTypeId())));
            return transactionLogSet;
        }
    }

    @Override
    public Set<TransactionLog> getByTypeId(int typeId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ITransactionLogDAO transactionLogDAO = session.getMapper(ITransactionLogDAO.class);
            Set<TransactionLog> transactionLogSet = transactionLogDAO.getByTypeId(typeId);
            ITransactionTypeDAO transactionTypeDAO = session.getMapper(ITransactionTypeDAO.class);
            transactionLogSet.forEach(t -> t.setTransactionType(transactionTypeDAO.getById(t.getTransactionTypeId())));
            return transactionLogSet;
        }
    }

    @Override
    public Set<TransactionLog> getByAccountId(int accountId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ITransactionLogDAO transactionLogDAO = session.getMapper(ITransactionLogDAO.class);
            Set<TransactionLog> transactionLogSet = transactionLogDAO.getByAccountId(accountId);
            ITransactionTypeDAO transactionTypeDAO = session.getMapper(ITransactionTypeDAO.class);
            transactionLogSet.forEach(t -> t.setTransactionType(transactionTypeDAO.getById(t.getTransactionTypeId())));
            return transactionLogSet;
        }
    }
}
