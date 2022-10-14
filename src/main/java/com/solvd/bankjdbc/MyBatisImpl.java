package com.solvd.bankjdbc;

import com.solvd.bankjdbc.models.*;
import com.solvd.bankjdbc.services.jdbcImpl.LoanService;
import com.solvd.bankjdbc.services.myBatisImpl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyBatisImpl {
    private static final Logger logger = LogManager.getLogger(MyBatisImpl.class);

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            employeeList.add(employeeService.getById(i));
        }
        employeeList.forEach(t -> logger.info(t.toString()));

        CardService cardService = new CardService();
        Set<Card> cardSet = cardService.getByAccountId(2);
        cardSet.forEach(t-> logger.info(t.toString()));

        CustomerService customerService = new CustomerService();
        Set<Customer> customerSet = customerService.getAll();
        customerSet.forEach(t-> logger.info(t.toString()));

        FixedTermDepositService fixedTermDepositService = new FixedTermDepositService();
        Set<FixedTermDeposit> fixedTermDepositSet = fixedTermDepositService.getAll();
        fixedTermDepositSet.forEach(t-> logger.info(t.toString()));

        LoanService loanService = new LoanService();
        Set<Loan> loanSet = loanService.getAll();
        loanSet.forEach(t-> logger.info(t.toString()));

        TransactionLogService transactionLogService = new TransactionLogService();
        Set<TransactionLog> transactionLogSet = transactionLogService.getAll();
        transactionLogSet.forEach(t -> logger.info(t.toString()));

        UserLoginService userLoginService = new UserLoginService();
        Set<UserLogin> userLoginSet = userLoginService.getAll();
        userLoginSet.forEach(t -> logger.info(t.toString()));
    }
}
