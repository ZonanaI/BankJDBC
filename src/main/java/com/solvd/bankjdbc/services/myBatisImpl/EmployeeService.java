package com.solvd.bankjdbc.services.myBatisImpl;

import com.solvd.bankjdbc.dao.IEmployeeDAO;
import com.solvd.bankjdbc.dao.mysql.EmployeeDAO;
import com.solvd.bankjdbc.models.Employee;
import com.solvd.bankjdbc.services.IEmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class EmployeeService implements IEmployeeService {

    private final static SqlSessionFactory sqlSessionFactory = MyBatisFactory.getSqlSessionFactory();
    @Override
    public void create(Employee employee) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IEmployeeDAO employeeDAO = session.getMapper(IEmployeeDAO.class);
            employeeDAO.create(employee);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Employee getById(int id) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            IEmployeeDAO employeeDAO = session.getMapper(IEmployeeDAO.class);
            return employeeDAO.getById(id);
        }
    }

    @Override
    public void update(Employee employee) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IEmployeeDAO employeeDAO = session.getMapper(IEmployeeDAO.class);
            employeeDAO.update(employee);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public void remove(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IEmployeeDAO employeeDAO = session.getMapper(IEmployeeDAO.class);
            employeeDAO.remove(id);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }
}
