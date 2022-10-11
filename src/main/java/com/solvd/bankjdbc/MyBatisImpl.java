package com.solvd.bankjdbc;

import com.solvd.bankjdbc.models.Card;
import com.solvd.bankjdbc.models.Employee;
import com.solvd.bankjdbc.services.myBatisImpl.CardService;
import com.solvd.bankjdbc.services.myBatisImpl.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
    }
}
