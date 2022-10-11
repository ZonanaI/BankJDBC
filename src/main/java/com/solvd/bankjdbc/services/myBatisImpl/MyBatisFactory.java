package com.solvd.bankjdbc.services.myBatisImpl;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class MyBatisFactory {
    private final static Logger logger = LogManager.getLogger(MyBatisFactory.class);
    private final static MyBatisFactory daoFactory;
    private static SqlSessionFactory sqlSessionFactory;


    static {
        try {
            daoFactory = new MyBatisFactory();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private MyBatisFactory () throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
