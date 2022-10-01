package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.ITransactionLogDAO;
import com.solvd.bankjdbc.models.TransactionLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

public class TransactionLogDAO extends AbstractMySQL implements ITransactionLogDAO {

    private static final Logger logger = LogManager.getLogger(TransactionLogDAO.class);

    private static final String CREATE_TRANSACTION_LOG = "INSERT INTO TransactionLog (transaction_date, " +
            "transaction_amount, new_balance, employee_id, account_id, transaction_type_id) VALUES (?,?,?,?,?,?)";
    private static final String GET_TRANSACTION_LOG_BY_ID = "SELECT transaction_log_id, transaction_date, " +
            "transaction_amount, new_balance, employee_id, account_id, transaction_type_id " +
            "FROM TransactionLog " +
            "WHERE transaction_log_id = ?";
    private static final String UPDATE_TRANSACTION_LOG = "UPDATE TransactionLog SET transaction_date = ?, " +
            "transaction_amount = ?, new_balance = ?, employee_id = ?, account_id = ?, transaction_type_id= ? " +
            "WHERE transaction_log_id = ?";
    private static final String DELETE_TRANSACTION_LOG = "DELETE FROM TransactionLog " +
            "WHERE transaction_log_id = ?";
    private static final String GET_ALL = "SELECT transaction_log_id, transaction_date, " +
            "transaction_amount, new_balance, employee_id, account_id, transaction_type_id " +
            "FROM TransactionLog";
    private static final String GET_BY_DATES = "SELECT transaction_log_id, transaction_date, " +
            "transaction_amount, new_balance, employee_id, account_id, transaction_type_id " +
            "FROM TransactionLog " +
            "WHERE transaction_date BETWEEN ? AND ? " +
            "ORDERED BY transaction_date ASC";
    private static final String GET_BY_TYPE_ID = "SELECT transaction_log_id, transaction_date, " +
            "transaction_amount, new_balance, employee_id, account_id, transaction_type_id " +
            "FROM TransactionLog " +
            "WHERE transaction_type_id = ?";
    private static final String GET_BY_ACCOUNT_ID = "SELECT transaction_log_id, transaction_date, " +
            "transaction_amount, new_balance, employee_id, account_id, transaction_type_id " +
            "FROM TransactionLog " +
            "WHERE account_id = ?";

    @Override
    public void create(TransactionLog transactionLog) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_TRANSACTION_LOG, Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, transactionLog.getTransactionDate());
            ps.setBigDecimal(2, transactionLog.getTransactionAmount());
            ps.setBigDecimal(3, transactionLog.getNewBalance());
            ps.setInt(4, transactionLog.getEmployeeId());
            ps.setInt(5, transactionLog.getAccountId());
            ps.setInt(6, transactionLog.getTransactionTypeId());
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
    public TransactionLog getById(int id) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TransactionLog transactionLog = new TransactionLog();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_TRANSACTION_LOG_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            transactionLog.setId(rs.getInt("transaction_log_id"));
            transactionLog.setTransactionDate((LocalDateTime) rs.getObject("transaction_date"));
            transactionLog.setTransactionAmount(rs.getBigDecimal("transaction_amount"));
            transactionLog.setEmployeeId(rs.getInt("employee_id"));
            transactionLog.setAccountId(rs.getInt("account_id"));
            transactionLog.setTransactionTypeId(rs.getInt("transaction_type_id"));
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
        return transactionLog;
    }

    @Override
    public void update(TransactionLog transactionLog) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_TRANSACTION_LOG, Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, transactionLog.getTransactionDate());
            ps.setBigDecimal(2, transactionLog.getTransactionAmount());
            ps.setBigDecimal(3, transactionLog.getNewBalance());
            ps.setInt(4, transactionLog.getEmployeeId());
            ps.setInt(5, transactionLog.getAccountId());
            ps.setInt(6, transactionLog.getTransactionTypeId());
            ps.setInt(7,transactionLog.getId());
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
            ps = c.prepareStatement(DELETE_TRANSACTION_LOG, Statement.RETURN_GENERATED_KEYS);
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
    public Set<TransactionLog> getAll() {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<TransactionLog> transactionLogTreeSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_ALL, Statement.RETURN_GENERATED_KEYS);
            rs = ps.executeQuery();

            while (rs.next()){
                TransactionLog transactionLog = new TransactionLog();
                transactionLog.setId(rs.getInt("transaction_log_id"));
                transactionLog.setTransactionDate((LocalDateTime) rs.getObject("transaction_date"));
                transactionLog.setTransactionAmount(rs.getBigDecimal("transaction_amount"));
                transactionLog.setEmployeeId(rs.getInt("employee_id"));
                transactionLog.setAccountId(rs.getInt("account_id"));
                transactionLog.setTransactionTypeId(rs.getInt("transaction_type_id"));
                transactionLogTreeSet.add(transactionLog);
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
        return transactionLogTreeSet;
    }

    @Override
    public Set<TransactionLog> getByDateTimeRange(LocalDateTime firstDateTime, LocalDateTime lastDateTime) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<TransactionLog> transactionLogTreeSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_DATES, Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, firstDateTime);
            ps.setObject(2, lastDateTime);
            rs = ps.executeQuery();

            while (rs.next()){
                TransactionLog transactionLog = new TransactionLog();
                transactionLog.setId(rs.getInt("transaction_log_id"));
                transactionLog.setTransactionDate((LocalDateTime) rs.getObject("transaction_date"));
                transactionLog.setTransactionAmount(rs.getBigDecimal("transaction_amount"));
                transactionLog.setEmployeeId(rs.getInt("employee_id"));
                transactionLog.setAccountId(rs.getInt("account_id"));
                transactionLog.setTransactionTypeId(rs.getInt("transaction_type_id"));
                transactionLogTreeSet.add(transactionLog);
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
        return transactionLogTreeSet;
    }

    @Override
    public Set<TransactionLog> getByTypeId(int typeId) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<TransactionLog> transactionLogTreeSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_TYPE_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, typeId);
            rs = ps.executeQuery();

            while (rs.next()){
                TransactionLog transactionLog = new TransactionLog();
                transactionLog.setId(rs.getInt("transaction_log_id"));
                transactionLog.setTransactionDate((LocalDateTime) rs.getObject("transaction_date"));
                transactionLog.setTransactionAmount(rs.getBigDecimal("transaction_amount"));
                transactionLog.setEmployeeId(rs.getInt("employee_id"));
                transactionLog.setAccountId(rs.getInt("account_id"));
                transactionLog.setTransactionTypeId(rs.getInt("transaction_type_id"));
                transactionLogTreeSet.add(transactionLog);
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
        return transactionLogTreeSet;
    }

    @Override
    public Set<TransactionLog> getByAccountId(int accountId) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<TransactionLog> transactionLogTreeSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_ACCOUNT_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, accountId);
            rs = ps.executeQuery();

            while (rs.next()){
                TransactionLog transactionLog = new TransactionLog();
                transactionLog.setId(rs.getInt("transaction_log_id"));
                transactionLog.setTransactionDate((LocalDateTime) rs.getObject("transaction_date"));
                transactionLog.setTransactionAmount(rs.getBigDecimal("transaction_amount"));
                transactionLog.setEmployeeId(rs.getInt("employee_id"));
                transactionLog.setAccountId(rs.getInt("account_id"));
                transactionLog.setTransactionTypeId(rs.getInt("transaction_type_id"));
                transactionLogTreeSet.add(transactionLog);
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
        return transactionLogTreeSet;
    }
}
