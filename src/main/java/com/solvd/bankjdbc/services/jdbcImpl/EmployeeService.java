package com.solvd.bankjdbc.services.jdbcImpl;

import com.solvd.bankjdbc.dao.IEmployeeDAO;
import com.solvd.bankjdbc.dao.mysql.EmployeeDAO;
import com.solvd.bankjdbc.models.Employee;
import com.solvd.bankjdbc.services.IEmployeeService;

public class EmployeeService implements IEmployeeService {

    private final IEmployeeDAO employeeDAO = new EmployeeDAO();
    @Override
    public void create(Employee employee) {
        employeeDAO.create(employee);
    }
    @Override
    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }
    @Override
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }
    @Override
    public void remove(int id) {
        employeeDAO.remove(id);
    }
}
