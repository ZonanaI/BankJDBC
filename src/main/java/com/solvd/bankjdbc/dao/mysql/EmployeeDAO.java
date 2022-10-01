package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.IEmployeeDAO;
import com.solvd.bankjdbc.models.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class EmployeeDAO extends AbstractMySQL implements IEmployeeDAO {

    private static final Logger logger = LogManager.getLogger(EmployeeDAO.class);

    private static final String CREATE_EMPLOYEE = "INSERT INTO Employee (firs_name, last_name) VALUES (?,?)";
    private static final String GET_EMPLOYEE_BY_ID = "SELECT employee_id, firs_name, last_name, " +
            "FROM Employee " +
            "WHERE employee_id = ?";
    private static final String UPDATE_EMPLOYEE = "UPDATE Employee SET firs_name = ?, last_name = ?, " +
            "WHERE employee_id = ?";
    private static final String DELETE_EMPLOYEE = "DELETE FROM Employee WHERE employee_id = ?";

    @Override
    public void create(Employee employee) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_EMPLOYEE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            rs = ps.executeQuery();
            rs.next();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Override
    public Employee getById(int id) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Employee employee = new Employee();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_EMPLOYEE_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            employee.setId(rs.getInt("employee_id"));
            employee.setFirstName(rs.getString("firs_name"));
            employee.setLastName(rs.getString("last_name"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return employee;
    }

    @Override
    public void update(Employee employee) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_EMPLOYEE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getId());
            rs = ps.executeQuery();
            rs.next();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Override
    public void remove(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(DELETE_EMPLOYEE, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
