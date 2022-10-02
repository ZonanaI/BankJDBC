package com.solvd.bankjdbc.services;

import com.solvd.bankjdbc.dao.IAccountDAO;
import com.solvd.bankjdbc.dao.ICustomerDAO;
import com.solvd.bankjdbc.dao.mysql.AccountDAO;
import com.solvd.bankjdbc.dao.mysql.CustomerDAO;
import com.solvd.bankjdbc.models.Customer;

import java.util.Set;

public class CustomerService {
    private final ICustomerDAO customerDAO = new CustomerDAO();
    private final IAccountDAO accountDAO = new AccountDAO();

    public void create(Customer customer) {
        customerDAO.create(customer);
    }

    public Customer getById(int id) {
        Customer customer = customerDAO.getById(id);
        customer.setAccountSet(accountDAO.getByCustomerId(id));
        return customer;
    }

    public void update(Customer customer) {
        customerDAO.update(customer);
    }

    public void remove(int id) {
        customerDAO.remove(id);
    }

    public Set<Customer> getAll() {
        Set<Customer> customerSet = customerDAO.getAll();
        customerSet.forEach(t-> t.setAccountSet(accountDAO.getByCustomerId(t.getId())));
        return customerSet;
    }

    public Set<Customer> getByCity(String city) {
        Set<Customer> customerSet = customerDAO.getByCity(city);
        customerSet.forEach(t-> t.setAccountSet(accountDAO.getByCustomerId(t.getId())));
        return customerSet;
    }

    public Set<Customer> getByState(String state) {
        Set<Customer> customerSet = customerDAO.getByState(state);
        customerSet.forEach(t-> t.setAccountSet(accountDAO.getByCustomerId(t.getId())));
        return customerSet;
    }

    public Set<Customer> getByAccountId(int accountId) {
        Set<Customer> customerSet = customerDAO.getByAccountId(accountId);
        customerSet.forEach(t-> t.setAccountSet(accountDAO.getByCustomerId(t.getId())));
        return customerSet;
    }
}
