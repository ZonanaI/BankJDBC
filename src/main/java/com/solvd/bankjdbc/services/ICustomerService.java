package com.solvd.bankjdbc.services;

import com.solvd.bankjdbc.models.Customer;

import java.util.Set;

public interface ICustomerService  extends IBaseService<Customer> {
    Set<Customer> getAll();
    Set<Customer> getByCity(String city);
    Set<Customer> getByState(String state);
    Set<Customer> getByAccountId (int accountId);
}
