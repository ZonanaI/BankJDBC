package com.solvd.bankjdbc.dao;

public interface IBaseDAO<T>{
    void create (T object);
    T getById (int id);
    void update (T object);
    void remove (int id);
}
