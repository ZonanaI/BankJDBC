package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.ITransactionTypeDAO;
import com.solvd.bankjdbc.models.TransactionType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class TransactionTypeDAO extends AbstractMySQL implements ITransactionTypeDAO {
    
    private static final Logger logger = LogManager.getLogger(TransactionTypeDAO.class);

    private static final String CREATE_TRANSACTION_TYPE = "INSERT INTO TransactionType (transaction_name, " +
            "fee_amount, transaction_description) VALUES (?,?,?,?)";
    private static final String GET_TRANSACTION_TYPE_BY_ID = "SELECT transaction_type_id, transaction_name, " +
            "fee_amount, transaction_description " +
            "FROM TransactionType " +
            "WHERE transaction_type_id = ?";
    private static final String UPDATE_TRANSACTION_TYPE = "UPDATE TransactionType SET transaction_name = ?, " +
            "fee_amount = ?, transaction_description = ? " +
            "WHERE transaction_type_id = ?";
    private static final String DELETE_TRANSACTION_TYPE = "DELETE FROM TransactionType " +
            "WHERE transaction_type_id = ?";
    @Override
    public void create(TransactionType transactionType) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_TRANSACTION_TYPE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, transactionType.getName());
            ps.setBigDecimal(2, transactionType.getFeeAmount());
            ps.setString(3, transactionType.getDescription());
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
    public TransactionType getById(int id) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TransactionType transactionType = new TransactionType();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_TRANSACTION_TYPE_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            transactionType.setId(rs.getInt("transaction_type_id"));
            transactionType.setName(rs.getString("transaction_name"));
            transactionType.setFeeAmount(rs.getBigDecimal("fee_amount"));
            transactionType.setDescription(rs.getString("transaction_description"));
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
        return transactionType;
    }

    @Override
    public void update(TransactionType transactionType) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_TRANSACTION_TYPE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, transactionType.getName());
            ps.setBigDecimal(2, transactionType.getFeeAmount());
            ps.setString(3, transactionType.getDescription());
            ps.setInt(4,transactionType.getId());
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
            ps = c.prepareStatement(DELETE_TRANSACTION_TYPE, Statement.RETURN_GENERATED_KEYS);
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
