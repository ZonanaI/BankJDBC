package com.solvd.bankjdbc.services;

public interface IBaseService<T> {
    void create (T object);
    T getById (int id);
    void update (T object);
    void remove (int id);
}
