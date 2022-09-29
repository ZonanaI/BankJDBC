package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.Customer;

import java.util.List;

public interface ICustomerDAO extends IBaseDao<Customer>{
    List<Customer> getAll();
    List<Customer> getByCity(String city);
    List<Customer> getByState(String state);
}
