package com.solvd.bankjdbc.services.myBatisImpl;

import com.solvd.bankjdbc.dao.ICustomerDAO;
import com.solvd.bankjdbc.models.Customer;
import com.solvd.bankjdbc.services.ICustomerService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Set;

public class CustomerService implements ICustomerService {

    private final static SqlSessionFactory sqlSessionFactory = MyBatisFactory.getSqlSessionFactory();
    @Override
    public void create(Customer customer) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
            customerDAO.create(customer);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }   
    }

    @Override
    public Customer getById(int id) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
            return customerDAO.getById(id);
        }
    }

    @Override
    public void update(Customer customer) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
            customerDAO.update(customer);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public void remove(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
            customerDAO.remove(id);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Set<Customer> getAll() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
            return customerDAO.getAll();
        }
    }

    @Override
    public Set<Customer> getByCity(String city) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
            return customerDAO.getByCity(city);
        }
    }

    @Override
    public Set<Customer> getByState(String state) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
            return customerDAO.getByState(state);
        }
    }

    @Override
    public Set<Customer> getByAccountId(int accountId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
            return customerDAO.getByAccountId(accountId);
        }
    }
}
