package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.Customer;

import java.util.List;
import java.util.Set;

public interface ICustomerDAO extends IBaseDao<Customer>{
    Set<Customer> getAll();
    Set<Customer> getByCity(String city);
    Set<Customer> getByState(String state);
    Set<Customer> getByAccountId (int accountId);
}
