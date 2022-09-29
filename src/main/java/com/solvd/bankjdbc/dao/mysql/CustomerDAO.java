package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.ICustomerDAO;
import com.solvd.bankjdbc.models.Customer;

import java.util.List;

public class CustomerDAO extends AbstractMySQL implements ICustomerDAO {
    @Override
    public void create(Customer object) {

    }

    @Override
    public Customer getById(int id) {
        return null;
    }

    @Override
    public void update(Customer object) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public List<Customer> getByCity(String city) {
        return null;
    }

    @Override
    public List<Customer> getByState(String state) {
        return null;
    }
}
