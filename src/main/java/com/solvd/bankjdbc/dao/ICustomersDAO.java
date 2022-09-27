package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.Customers;

import java.util.List;

public interface ICustomersDAO extends IBaseDao<Customers>{
    List<Customers> getAll();
    List<Customers> getByCity(String city);
    List<Customers> getByState(String state);
}
