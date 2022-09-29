package com.solvd.bankjdbc.connectionPools;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {
    private static final Logger log = LogManager.getLogger(ConnectionPool.class);
    static Properties properties= new Properties();
    public static final int MAX_POOL_SIZE = 5;

    private static BasicDataSource dataSource;

    public static BasicDataSource getDataSource (){
        try {
            properties.load(new FileInputStream("src/main/resources/configuration.properties"));
        } catch (IOException e){
            log.error(e);
        }
        if (dataSource == null){
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(properties.getProperty("DRIVER"));
            dataSource.setUsername(properties.getProperty("USER"));
            dataSource.setPassword(properties.getProperty("PASS"));
            dataSource.setUrl(properties.getProperty("URL"));

            dataSource.setMinIdle(1);
            dataSource.setMaxIdle(MAX_POOL_SIZE);
            dataSource.setMaxTotal(MAX_POOL_SIZE);
            dataSource.setMaxOpenPreparedStatements(200);
            dataSource.setMaxWaitMillis(-1);
        }
        return dataSource;
    }


    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
