package com.solvd.bankjdbc.services.myBatisImpl;

import com.solvd.bankjdbc.dao.*;
import com.solvd.bankjdbc.models.Account;
import com.solvd.bankjdbc.services.IAccountService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Set;

public class AccountService implements IAccountService {

    private final static SqlSessionFactory sqlSessionFactory = MyBatisFactory.getSqlSessionFactory();
    @Override
    public void create(Account account) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
            accountDAO.create(account);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }   
    }

    @Override
    public Account getById(int id) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
            Account account = accountDAO.getById(id); 
            return setAccountObjects(account, session, id);
        }
    }

    @Override
    public void update(Account account) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
            accountDAO.update(account);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public void remove(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
            accountDAO.remove(id);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Set<Account> getAll() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
            Set<Account> accountSet = accountDAO.getAll();
            return setAccountsObjects(accountSet,session);
        }
    }

    @Override
    public Set<Account> getByTypeId(int typeId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
            Set<Account> accountSet = accountDAO.getByTypeId(typeId);
            return setAccountsObjects(accountSet,session);
        }
    }

    @Override
    public Set<Account> getByStatusId(int statusId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
            Set<Account> accountSet = accountDAO.getByStatusId(statusId);
            return setAccountsObjects(accountSet,session);
        }
    }

    @Override
    public Set<Account> getByCustomerId(int customerId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
            Set<Account> accountSet = accountDAO.getByCustomerId(customerId);
            return setAccountsObjects(accountSet,session);
        }
    }

    @Override
    public Set<Account> getByUserLoginId(int userLoginId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
            Set<Account> accountSet = accountDAO.getByUserLoginId(userLoginId);
            return setAccountsObjects(accountSet,session);
        }
    }

    @Override
    public Account getByAccountNumberId(int accountNumberId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
            return accountDAO.getByAccountNumberId(accountNumberId );
        }
    }

    //Methods to set account associated objects: customers, cards, loans, fixed term deposits, transaction logs
    private Set<Account> setAccountsObjects (Set<Account> accountSet, SqlSession session){
        ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
        accountSet.forEach(t ->t.setCustomerSet(customerDAO.getByAccountId(t.getId())));
        IUserLoginDAO userLoginDAO = session.getMapper(IUserLoginDAO.class);
        accountSet.forEach(t ->t.setUserLoginSet(userLoginDAO.getByAccountId(t.getId())));
        ICardDAO cardDAO = session.getMapper(ICardDAO.class);
        accountSet.forEach(t ->t.setCardSet(cardDAO.getByAccountId(t.getId())));
        ILoanDAO loanDAO = session.getMapper(ILoanDAO.class);
        accountSet.forEach(t ->t.setLoanSet(loanDAO.getByAccountId(t.getId())));
        IFixedTermDepositDAO fixedTermDepositDAO = session.getMapper(IFixedTermDepositDAO.class);
        accountSet.forEach(t ->t.setFixedTermDepositSet(fixedTermDepositDAO.getByAccountId(t.getId())));
        ITransactionLogDAO transactionLogDAO = session.getMapper(ITransactionLogDAO.class);
        accountSet.forEach(t ->t.setTransactionLogSet(transactionLogDAO.getByAccountId(t.getId())));
        return accountSet;
    }
    private Account setAccountObjects (Account account, SqlSession session, int id){
        ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
        account.setCustomerSet(customerDAO.getByAccountId(id));
        IUserLoginDAO userLoginDAO = session.getMapper(IUserLoginDAO.class);
        account.setUserLoginSet(userLoginDAO.getByAccountId(id));
        ICardDAO cardDAO = session.getMapper(ICardDAO.class);
        account.setCardSet(cardDAO.getByAccountId(id));
        ILoanDAO loanDAO = session.getMapper(ILoanDAO.class);
        account.setLoanSet(loanDAO.getByAccountId(id));
        IFixedTermDepositDAO fixedTermDepositDAO = session.getMapper(IFixedTermDepositDAO.class);
        account.setFixedTermDepositSet(fixedTermDepositDAO.getByAccountId(id));
        ITransactionLogDAO transactionLogDAO = session.getMapper(ITransactionLogDAO.class);
        account.setTransactionLogSet(transactionLogDAO.getByAccountId(id));
        return account;
    }
}
