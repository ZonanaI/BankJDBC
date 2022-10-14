package com.solvd.bankjdbc.services.jdbcImpl;

import com.solvd.bankjdbc.dao.*;
import com.solvd.bankjdbc.dao.mysql.*;
import com.solvd.bankjdbc.models.Account;
import com.solvd.bankjdbc.services.IAccountService;

import java.util.Set;

public class AccountService implements IAccountService {
    private final IAccountDAO accountDAO = new AccountDAO();
    private final ICustomerDAO customerDAO = new CustomerDAO();
    private final IUserLoginDAO userLoginDAO = new UserLoginDAO();
    private final ICardDAO cardDAO = new CardDAO();
    private final ILoanDAO loanDAO = new LoanDAO();
    private final IFixedTermDepositDAO fixedTermDepositDAO = new FixedTermDepositDAO();
    private final ITransactionLogDAO transactionLogDAO = new TransactionLogDAO();
    @Override
    public void create(Account account) {
        accountDAO.create(account);
    }
    @Override
    public Account getById(int id) {
        Account account = accountDAO.getById(id);
        account.setCustomerSet(customerDAO.getByAccountId(id));
        account.setUserLoginSet(userLoginDAO.getByAccountId(id));
        account.setCardSet(cardDAO.getByAccountId(id));
        account.setLoanSet(loanDAO.getByAccountId(id));
        account.setFixedTermDepositSet(fixedTermDepositDAO.getByAccountId(id));
        account.setTransactionLogSet(transactionLogDAO.getByAccountId(id));
        return account;
    }
    @Override
    public void update(Account account) {
        accountDAO.update(account);
    }
    @Override
    public void remove(int id) {
        accountDAO.remove(id);
    }
    @Override
    public Account getByAccountNumberId(int accountNumberId) {
        Account account = accountDAO.getByAccountNumberId(accountNumberId);
        int id = account.getId();
        account.setCustomerSet(customerDAO.getByAccountId(id));
        account.setUserLoginSet(userLoginDAO.getByAccountId(id));
        account.setCardSet(cardDAO.getByAccountId(id));
        account.setLoanSet(loanDAO.getByAccountId(id));
        account.setFixedTermDepositSet(fixedTermDepositDAO.getByAccountId(id));
        account.setTransactionLogSet(transactionLogDAO.getByAccountId(id));
        return account;
    }
    @Override
    public Set<Account> getAll() {
        Set<Account> accountSet = accountDAO.getAll();
        for (Account account:
             accountSet) {
            account.setCustomerSet(customerDAO.getByAccountId(account.getId()));
            account.setUserLoginSet(userLoginDAO.getByAccountId(account.getId()));
            account.setCardSet(cardDAO.getByAccountId(account.getId()));
            account.setLoanSet(loanDAO.getByAccountId(account.getId()));
            account.setFixedTermDepositSet(fixedTermDepositDAO.getByAccountId(account.getId()));
            account.setTransactionLogSet(transactionLogDAO.getByAccountId(account.getId()));
        }
        return accountSet;
    }
    @Override
    public Set<Account> getByTypeId(int typeId) {
        Set<Account> accountSet = accountDAO.getByTypeId(typeId);
        for (Account account:
                accountSet) {
            account.setCustomerSet(customerDAO.getByAccountId(account.getId()));
            account.setUserLoginSet(userLoginDAO.getByAccountId(account.getId()));
            account.setCardSet(cardDAO.getByAccountId(account.getId()));
            account.setLoanSet(loanDAO.getByAccountId(account.getId()));
            account.setFixedTermDepositSet(fixedTermDepositDAO.getByAccountId(account.getId()));
            account.setTransactionLogSet(transactionLogDAO.getByAccountId(account.getId()));
        }
        return accountSet;
    }
    @Override
    public Set<Account> getByStatusId(int statusId) {
        Set<Account> accountSet = accountDAO.getByStatusId(statusId);
        for (Account account:
                accountSet) {
            account.setCustomerSet(customerDAO.getByAccountId(account.getId()));
            account.setUserLoginSet(userLoginDAO.getByAccountId(account.getId()));
            account.setCardSet(cardDAO.getByAccountId(account.getId()));
            account.setLoanSet(loanDAO.getByAccountId(account.getId()));
            account.setFixedTermDepositSet(fixedTermDepositDAO.getByAccountId(account.getId()));
            account.setTransactionLogSet(transactionLogDAO.getByAccountId(account.getId()));
        }
        return accountSet;
    }
    @Override
    public Set<Account> getByCustomerId(int customerId) {
        Set<Account> accountSet = accountDAO.getByCustomerId(customerId);
        for (Account account:
                accountSet) {
            account.setCustomerSet(customerDAO.getByAccountId(account.getId()));
            account.setUserLoginSet(userLoginDAO.getByAccountId(account.getId()));
            account.setCardSet(cardDAO.getByAccountId(account.getId()));
            account.setLoanSet(loanDAO.getByAccountId(account.getId()));
            account.setFixedTermDepositSet(fixedTermDepositDAO.getByAccountId(account.getId()));
            account.setTransactionLogSet(transactionLogDAO.getByAccountId(account.getId()));
        }
        return accountSet;
    }
    @Override
    public Set<Account> getByUserLoginId(int userLoginId) {
        Set<Account> accountSet = accountDAO.getByUserLoginId(userLoginId);
        for (Account account:
                accountSet) {
            account.setCustomerSet(customerDAO.getByAccountId(account.getId()));
            account.setUserLoginSet(userLoginDAO.getByAccountId(account.getId()));
            account.setCardSet(cardDAO.getByAccountId(account.getId()));
            account.setLoanSet(loanDAO.getByAccountId(account.getId()));
            account.setFixedTermDepositSet(fixedTermDepositDAO.getByAccountId(account.getId()));
            account.setTransactionLogSet(transactionLogDAO.getByAccountId(account.getId()));
        }
        return accountSet;
    }
}
