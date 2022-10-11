package com.solvd.bankjdbc.services.jdbcImpl;

import com.solvd.bankjdbc.dao.IAccountDAO;
import com.solvd.bankjdbc.dao.ICustomerDAO;
import com.solvd.bankjdbc.dao.mysql.AccountDAO;
import com.solvd.bankjdbc.dao.mysql.CustomerDAO;
import com.solvd.bankjdbc.models.Customer;
import com.solvd.bankjdbc.services.ICustomerService;

import java.util.Set;

public class CustomerService implements ICustomerService {
    private final ICustomerDAO customerDAO = new CustomerDAO();
    private final IAccountDAO accountDAO = new AccountDAO();
    @Override
    public void create(Customer customer) {
        customerDAO.create(customer);
    }
    @Override
    public Customer getById(int id) {
        Customer customer = customerDAO.getById(id);
        customer.setAccountSet(accountDAO.getByCustomerId(id));
        return customer;
    }
    @Override
    public void update(Customer customer) {
        customerDAO.update(customer);
    }
    @Override
    public void remove(int id) {
        customerDAO.remove(id);
    }
    @Override
    public Set<Customer> getAll() {
        Set<Customer> customerSet = customerDAO.getAll();
        customerSet.forEach(t-> t.setAccountSet(accountDAO.getByCustomerId(t.getId())));
        return customerSet;
    }
    @Override
    public Set<Customer> getByCity(String city) {
        Set<Customer> customerSet = customerDAO.getByCity(city);
        customerSet.forEach(t-> t.setAccountSet(accountDAO.getByCustomerId(t.getId())));
        return customerSet;
    }
    @Override
    public Set<Customer> getByState(String state) {
        Set<Customer> customerSet = customerDAO.getByState(state);
        customerSet.forEach(t-> t.setAccountSet(accountDAO.getByCustomerId(t.getId())));
        return customerSet;
    }
    @Override
    public Set<Customer> getByAccountId(int accountId) {
        Set<Customer> customerSet = customerDAO.getByAccountId(accountId);
        customerSet.forEach(t-> t.setAccountSet(accountDAO.getByCustomerId(t.getId())));
        return customerSet;
    }
}
