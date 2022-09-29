package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.IEmployeeDAO;
import com.solvd.bankjdbc.models.Employee;

public class EmployeeDAO extends AbstractMySQL implements IEmployeeDAO {
    @Override
    public void create(Employee object) {

    }

    @Override
    public Employee getById(int id) {
        return null;
    }

    @Override
    public void update(Employee object) {

    }

    @Override
    public void remove(int id) {

    }
}
