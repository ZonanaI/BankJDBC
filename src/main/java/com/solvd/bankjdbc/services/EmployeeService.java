package com.solvd.bankjdbc.services;

import com.solvd.bankjdbc.dao.IEmployeeDAO;
import com.solvd.bankjdbc.dao.mysql.EmployeeDAO;
import com.solvd.bankjdbc.models.Employee;

public class EmployeeService {

    private final IEmployeeDAO employeeDAO = new EmployeeDAO();

    public void create(Employee employee) {
        employeeDAO.create(employee);
    }

    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }

    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    public void remove(int id) {
        employeeDAO.remove(id);
    }
}
