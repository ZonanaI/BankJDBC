package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.connectionPools.ConnectionPool;
import org.apache.commons.dbcp2.BasicDataSource;

public abstract class AbstractMySQL {
    private final BasicDataSource cp = ConnectionPool.getDataSource();

    public BasicDataSource getCp() {
        return cp;
    }
}
