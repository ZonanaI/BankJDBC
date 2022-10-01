package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.IFailedTransactionLogDAO;
import com.solvd.bankjdbc.models.FailedTransactionLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class FailedTransactionLogDAO extends AbstractMySQL implements IFailedTransactionLogDAO {
    
    private static final Logger logger = LogManager.getLogger(FailedTransactionLogDAO.class);

    private static final String CREATE_FAILED_TRANSACTION_LOG = "INSERT INTO FailedTransactionLog " +
            "(failed_transaction_time, failed_transaction_error_type_id) VALUES (?,?)";
    private static final String GET_FAILED_TRANSACTION_LOG_BY_ID = "SELECT FTL.failed_transaction_log_id, " +
        "FTL.failed_transaction_time, FTL.failed_transaction_error_type_id, FTE.error_description " +
        "FROM FailedTransactionLog AS FTL " +
        "LEFT JOIN FailedTransactionErrorType AS FTE ON " +
            "FTL.failed_transaction_log_id = FTE.failed_transaction_error_type_id " +
        "WHERE FTL.failed_transaction_log_id = ?";
    private static final String UPDATE_FAILED_TRANSACTION_LOG = "UPDATE FailedTransactionLog SET " +
            "failed_transaction_time = ?, failed_transaction_error_type_id = ?, " +
            "WHERE failed_transaction_log_id = ?";
    private static final String DELETE_FAILED_TRANSACTION_LOG = "DELETE FROM FailedTransactionLog " +
            "WHERE failed_transaction_log_id = ?";
    private static final String GET_ALL = "SELECT FTL.failed_transaction_log_id, " +
            "FTL.failed_transaction_time, FTL.failed_transaction_error_type_id, FTE.error_description " +
            "FROM FailedTransactionLog AS FTL " +
            "LEFT JOIN FailedTransactionErrorType AS FTE ON " +
            "FTL.failed_transaction_log_id = FTE.failed_transaction_error_type_id ";
    private static final String GET_BY_DATES = "SELECT FTL.failed_transaction_log_id, " +
            "FTL.failed_transaction_time, FTL.failed_transaction_error_type_id, FTE.error_description " +
            "FROM FailedTransactionLog AS FTL " +
            "LEFT JOIN FailedTransactionErrorType AS FTE ON " +
            "FTL.failed_transaction_log_id = FTE.failed_transaction_error_type_id " +
            "WHERE FTL.failed_transaction_time BETWEEN ? AND ? " +
            "ORDERED BY FTL.failed_transaction_time ASC";
    private static final String GET_BY_ERROR_TYPE = "SELECT FTL.failed_transaction_log_id, " +
            "FTL.failed_transaction_time, FTL.failed_transaction_error_type_id, FTE.error_description " +
            "FROM FailedTransactionLog AS FTL " +
            "LEFT JOIN FailedTransactionErrorType AS FTE ON " +
            "FTL.failed_transaction_log_id = FTE.failed_transaction_error_type_id " +
            "WHERE FTE.error_description = ?";
    @Override
    public void create(FailedTransactionLog failedTransactionLog) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_FAILED_TRANSACTION_LOG, Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, failedTransactionLog.getFailedTransactionTime());
            ps.setInt(2, failedTransactionLog.getFailedTransactionErrorTypeId());
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
    public FailedTransactionLog getById(int id) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FailedTransactionLog failedTransactionLog = new FailedTransactionLog();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_FAILED_TRANSACTION_LOG_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            failedTransactionLog.setId(rs.getInt("failed_transaction_log_id"));
            failedTransactionLog.setFailedTransactionTime(
                    (LocalDateTime) rs.getObject("failed_transaction_time"));
            failedTransactionLog.setErrorType(rs.getString("error_description"));
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
        return failedTransactionLog;
    }

    @Override
    public void update(FailedTransactionLog failedTransactionLog) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_FAILED_TRANSACTION_LOG, Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, failedTransactionLog.getFailedTransactionTime());
            ps.setInt(2, failedTransactionLog.getFailedTransactionErrorTypeId());
            ps.setInt(3, failedTransactionLog.getId());
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
            ps = c.prepareStatement(DELETE_FAILED_TRANSACTION_LOG, Statement.RETURN_GENERATED_KEYS);
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
    public List<FailedTransactionLog> getAll() {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FailedTransactionLog> failedTransactionLogArrayList = new ArrayList<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_ALL, Statement.RETURN_GENERATED_KEYS);
            rs = ps.executeQuery();

            while (rs.next()){
                FailedTransactionLog failedTransactionLog = new FailedTransactionLog();
                failedTransactionLog.setId(rs.getInt("failed_transaction_log_id"));
                failedTransactionLog.setFailedTransactionTime(
                        (LocalDateTime) rs.getObject("failed_transaction_time"));
                failedTransactionLog.setErrorType(rs.getString("error_description"));
                failedTransactionLogArrayList.add(failedTransactionLog);
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
        return failedTransactionLogArrayList;
    }

    @Override
    public List<FailedTransactionLog> getByErrorType(String errorType) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FailedTransactionLog> failedTransactionLogArrayList = new ArrayList<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_ERROR_TYPE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, errorType);
            rs = ps.executeQuery();

            while (rs.next()){
                FailedTransactionLog failedTransactionLog = new FailedTransactionLog();
                failedTransactionLog.setId(rs.getInt("failed_transaction_log_id"));
                failedTransactionLog.setFailedTransactionTime(
                        (LocalDateTime) rs.getObject("failed_transaction_time"));
                failedTransactionLog.setErrorType(rs.getString("error_description"));
                failedTransactionLogArrayList.add(failedTransactionLog);
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
        return failedTransactionLogArrayList;
    }

    @Override
    public List<FailedTransactionLog> getByDateTimeRange(LocalDateTime firstDateTime, LocalDateTime lastDateTime) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FailedTransactionLog> failedTransactionLogArrayList = new ArrayList<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_DATES, Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, firstDateTime);
            ps.setObject(2, lastDateTime);
            rs = ps.executeQuery();

            while (rs.next()){
                FailedTransactionLog failedTransactionLog = new FailedTransactionLog();
                failedTransactionLog.setId(rs.getInt("failed_transaction_log_id"));
                failedTransactionLog.setFailedTransactionTime(
                        (LocalDateTime) rs.getObject("failed_transaction_time"));
                failedTransactionLog.setErrorType(rs.getString("error_description"));
                failedTransactionLogArrayList.add(failedTransactionLog);
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
        return failedTransactionLogArrayList;
    }
}
