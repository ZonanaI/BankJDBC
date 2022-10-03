package com.solvd.bankjdbc.services;

import com.solvd.bankjdbc.dao.IAccountDAO;
import com.solvd.bankjdbc.dao.IEmployeeDAO;
import com.solvd.bankjdbc.dao.ITransactionLogDAO;
import com.solvd.bankjdbc.dao.ITransactionTypeDAO;
import com.solvd.bankjdbc.dao.mysql.AccountDAO;
import com.solvd.bankjdbc.dao.mysql.EmployeeDAO;
import com.solvd.bankjdbc.dao.mysql.TransactionLogDAO;
import com.solvd.bankjdbc.dao.mysql.TransactionTypeDAO;
import com.solvd.bankjdbc.models.TransactionLog;

import java.time.LocalDateTime;
import java.util.Set;

public class TransactionLogService {

    private final ITransactionLogDAO transactionLogDAO = new TransactionLogDAO();
    private final IAccountDAO accountDAO = new AccountDAO();
    private final IEmployeeDAO employeeDAO = new EmployeeDAO();
    private final ITransactionTypeDAO transactionTypeDAO = new TransactionTypeDAO();

    public void create(TransactionLog transactionLog) {
        transactionLogDAO.create(transactionLog);
    }

    public TransactionLog getById(int id) {
        TransactionLog transactionLog = transactionLogDAO.getById(id);
        if(transactionLog.getEmployeeId()>0){
            transactionLog.setEmployee(employeeDAO.getById(transactionLog.getEmployeeId()));
        }
        transactionLog.setAccount(accountDAO.getById(transactionLog.getAccountId()));
        transactionLog.setTransactionType(transactionTypeDAO.getById(transactionLog.getTransactionTypeId()));
        return transactionLog;
    }

    public void update(TransactionLog transactionLog) {
        transactionLogDAO.update(transactionLog);
    }

    public void remove(int id) {
        transactionLogDAO.remove(id);
    }

    public Set<TransactionLog> getAll() {
        Set<TransactionLog> transactionLogSet = transactionLogDAO.getAll();
        for (TransactionLog transactionLog:
             transactionLogSet) {
            if(transactionLog.getEmployeeId()>0){
                transactionLog.setEmployee(employeeDAO.getById(transactionLog.getEmployeeId()));
            }
            transactionLog.setAccount(accountDAO.getById(transactionLog.getAccountId()));
            transactionLog.setTransactionType(transactionTypeDAO.getById(transactionLog.getTransactionTypeId()));
        }
        return transactionLogSet;
    }

    public Set<TransactionLog> getByDateTimeRange(LocalDateTime firstDateTime, LocalDateTime lastDateTime) {
        Set<TransactionLog> transactionLogSet = transactionLogDAO.getByDateTimeRange(firstDateTime, lastDateTime);
        for (TransactionLog transactionLog:
                transactionLogSet) {
            if(transactionLog.getEmployeeId()>0){
                transactionLog.setEmployee(employeeDAO.getById(transactionLog.getEmployeeId()));
            }
            transactionLog.setAccount(accountDAO.getById(transactionLog.getAccountId()));
            transactionLog.setTransactionType(transactionTypeDAO.getById(transactionLog.getTransactionTypeId()));
        }
        return transactionLogSet;
    }

    public Set<TransactionLog> getByTypeId(int typeId) {
        Set<TransactionLog> transactionLogSet = transactionLogDAO.getByTypeId(typeId);
        for (TransactionLog transactionLog:
                transactionLogSet) {
            if(transactionLog.getEmployeeId()>0){
                transactionLog.setEmployee(employeeDAO.getById(transactionLog.getEmployeeId()));
            }
            transactionLog.setAccount(accountDAO.getById(transactionLog.getAccountId()));
            transactionLog.setTransactionType(transactionTypeDAO.getById(transactionLog.getTransactionTypeId()));
        }
        return transactionLogSet;
    }

    public Set<TransactionLog> getByAccountId(int accountId) {
        Set<TransactionLog> transactionLogSet = transactionLogDAO.getByAccountId(accountId);
        for (TransactionLog transactionLog:
                transactionLogSet) {
            if(transactionLog.getEmployeeId()>0){
                transactionLog.setEmployee(employeeDAO.getById(transactionLog.getEmployeeId()));
            }
            transactionLog.setAccount(accountDAO.getById(transactionLog.getAccountId()));
            transactionLog.setTransactionType(transactionTypeDAO.getById(transactionLog.getTransactionTypeId()));
        }
        return transactionLogSet;
    }
}
