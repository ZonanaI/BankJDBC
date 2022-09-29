package com.solvd.bankjdbc.dao;

public interface IBaseDao <T>{
    void create (T object);
    T getById (int id);
    void update (T object);
    void remove (int id);
}
