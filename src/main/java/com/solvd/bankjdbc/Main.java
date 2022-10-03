package com.solvd.bankjdbc;

import com.solvd.bankjdbc.services.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

        AccountService accountService = new AccountService();
        CustomerService customerService = new CustomerService();
        FailedTransactionService failedTransactionService = new FailedTransactionService();
        TransactionLogService transactionLogService = new TransactionLogService();
        UserLoginService userLoginService = new UserLoginService();
        List<Set> setList = new ArrayList<>();
        setList.add(accountService.getAll());
        setList.add(customerService.getAll());
        setList.add(failedTransactionService.getAll());
        setList.add(transactionLogService.getAll());
        setList.add(userLoginService.getAll());
        setList.forEach(t -> t.forEach(s ->logger.info(s.toString())));
    }
}
