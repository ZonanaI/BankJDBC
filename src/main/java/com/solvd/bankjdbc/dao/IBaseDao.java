package com.solvd.bankjdbc.dao;

public interface IBaseDao <T>{
    void create (T object);
    T getById (long id);
    void update (T object);
    void remove (long id);
}
