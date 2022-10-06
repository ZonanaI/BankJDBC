package com.solvd.bankjdbc;

import com.solvd.bankjdbc.dto.json.EmployeeDTO;
import com.solvd.bankjdbc.dto.json.CardDTO;
import com.solvd.bankjdbc.models.Card;
import com.solvd.bankjdbc.models.Employee;
import com.solvd.bankjdbc.models.Employees;
import com.solvd.bankjdbc.services.CardService;
import com.solvd.bankjdbc.services.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class JacksonImplementation {
    private static final Logger logger = LogManager.getLogger(JacksonImplementation.class);

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        CardService cardService = new CardService();
        CardDTO cardDTO = new CardDTO();

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
        } catch (IOException e) {
            logger.error(e);
        }
        try {
            employeeDTO.marshalCollection(employees.getEmployees());
        } catch (IOException e) {
            logger.error(e);
        }

        
        //Card marshalling example
        Card card1 = cardService.getById(1);
        try {
            cardDTO.marshal(card1);
        } catch (IOException e){
            logger.error(e);
        }
        Set<Card> cardSet = new TreeSet<>();
        for (int i = 1; i < 5; i++) {
            cardSet.add(cardService.getById(i));
        }
        try{
            cardDTO.marshalCollection(cardSet);
        }catch (IOException e){
            logger.error(e);
        }
    }
}
