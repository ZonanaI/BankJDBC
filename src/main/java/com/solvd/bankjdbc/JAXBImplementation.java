package com.solvd.bankjdbc;

import com.solvd.bankjdbc.dto.AccountDTO;
import com.solvd.bankjdbc.dto.CardDTO;
import com.solvd.bankjdbc.dto.EmployeeDTO;
import com.solvd.bankjdbc.models.Account;
import com.solvd.bankjdbc.models.Card;
import com.solvd.bankjdbc.models.Employee;
import com.solvd.bankjdbc.models.Employees;
import com.solvd.bankjdbc.services.AccountService;
import com.solvd.bankjdbc.services.CardService;
import com.solvd.bankjdbc.services.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class JAXBImplementation {

    private static final Logger logger = LogManager.getLogger(JAXBImplementation.class);
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        CardService cardService = new CardService();
        CardDTO cardDTO = new CardDTO();
        AccountService accountService = new AccountService();
        AccountDTO accountDTO = new AccountDTO();


        //Employee marshalling example
        Employee employee1 = employeeService.getById(1);
        Employees employees = new Employees();
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            employeeList.add(employeeService.getById(i));
        }
        employees.setEmployees(employeeList);
        try {
            employeeDTO.marshal(employee1);
        } catch (JAXBException e) {
            logger.error(e);
        }
        try {
            employeeDTO.marshalCollection(employees.getEmployees());
        } catch (JAXBException e) {
            logger.error(e);
        }


        //Card marshalling example
        Card card1 = cardService.getById(1);
        try {
            cardDTO.marshal(card1);
        } catch (JAXBException e){
            logger.error(e);
        }
        Set<Card> cardSet = new TreeSet<>();
        for (int i = 1; i < 5; i++) {
            cardSet.add(cardService.getById(i));
        }
        try{
            cardDTO.marshalCollection(cardSet);
        }catch (JAXBException e){
            logger.error(e);
        }

        //Account marshalling example
        Account account1 = accountService.getById(1);
        Set<Account> accountSet = new TreeSet<>();
        accountSet = accountService.getAll();

        try {
            accountDTO.marshal(account1);
        } catch (JAXBException e){
            logger.error(e);
        }
        try {
            accountDTO.marshalCollection(accountSet);
        } catch (JAXBException e){
            logger.error(e);
        }

    }

}
