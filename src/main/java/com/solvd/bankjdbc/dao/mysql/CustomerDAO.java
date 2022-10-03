package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.ICustomerDAO;
import com.solvd.bankjdbc.models.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

public class CustomerDAO extends AbstractMySQL implements ICustomerDAO {

    private static final Logger logger = LogManager.getLogger(CustomerDAO.class);

    private static final String CREATE_CUSTOMER = "INSERT INTO Customer (first_name, last_name, " +
            "address, city, state, phone) VALUES (?,?,?,?,?,?)";
    private static final String GET_CUSTOMER_BY_ID = "SELECT customer_id, first_name, last_name, " +
            "address, city, state, phone " +
            "FROM Customer " +
            "WHERE customer_id = ?";
    private static final String UPDATE_CUSTOMER = "UPDATE Customer SET first_name = ?, last_name = ?, " +
            "address = ?, city = ?, state = ?, phone = ? WHERE customer_id = ?";
    private static final String DELETE_CUSTOMER = "DELETE FROM Customer WHERE customer_id = ?";
    private static final String GET_ALL = "SELECT customer_id, first_name, last_name, address, city, state, phone " +
            "FROM Customer";
    private static final String GET_BY_CUSTOMER_CITY = "SELECT customer_id, first_name, last_name, address, city, state, phone " +
            "FROM Customer " +
            "WHERE city = ?";
    private static final String GET_BY_CUSTOMER_STATE = "SELECT customer_id, first_name, last_name, address, city, state, phone " +
            "FROM Customer " +
            "WHERE state = ?";
    private static final String GET_BY_ACCOUNT_NUMBER_ID = "SELECT Customer.customer_id, Customer.first_name, " +
            "Customer.last_name,  Customer.address, Customer.city, Customer.state, Customer.phone " +
            "FROM Customer " +
            "INNER JOIN CustomerAccount ON Customer.customer_id = CustomerAccount.customer_id " +
            "WHERE CustomerAccount.account_id = ?";
    @Override
    public void create(Customer customer) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_CUSTOMER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getCity());
            ps.setString(5, customer.getState());
            ps.setString(6, customer.getPhone());
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
    public Customer getById(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer customer = new Customer();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_CUSTOMER_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            customer.setId(rs.getInt("customer_id"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setAddress(rs.getString("address"));
            customer.setCity(rs.getString("city"));
            customer.setState(rs.getString("state"));
            customer.setPhone(rs.getString("phone"));
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
        return customer;
    }

    @Override
    public void update(Customer customer) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_CUSTOMER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getCity());
            ps.setString(5, customer.getState());
            ps.setString(6, customer.getPhone());
            ps.setInt(7, customer.getId());
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
            ps = c.prepareStatement(DELETE_CUSTOMER, Statement.RETURN_GENERATED_KEYS);
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

    @Override
    public Set<Customer> getAll() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<Customer> customerSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_ALL, Statement.RETURN_GENERATED_KEYS);
            rs = ps.executeQuery();

            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setAddress(rs.getString("address"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setPhone(rs.getString("phone"));
                customerSet.add(customer);
            }
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
        return customerSet;
    }

    @Override
    public Set<Customer> getByCity(String city) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<Customer> customerSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_CUSTOMER_CITY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,city);
            rs = ps.executeQuery();

            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setAddress(rs.getString("address"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setPhone(rs.getString("phone"));
                customerSet.add(customer);
            }
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
        return customerSet;
    }

    @Override
    public Set<Customer> getByState(String state) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<Customer> customerSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_CUSTOMER_STATE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,state);
            rs = ps.executeQuery();

            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setAddress(rs.getString("address"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setPhone(rs.getString("phone"));
                customerSet.add(customer);
            }
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
        return customerSet;
    }

    @Override
    public Set<Customer> getByAccountId(int accountId) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<Customer> customerSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_ACCOUNT_NUMBER_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,accountId);
            rs = ps.executeQuery();

            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setAddress(rs.getString("address"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setPhone(rs.getString("phone"));
                customerSet.add(customer);
            }
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
        return customerSet;
    }
}
