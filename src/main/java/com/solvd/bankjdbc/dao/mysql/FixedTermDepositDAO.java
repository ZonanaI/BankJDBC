package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.IFixedTermDepositDAO;
import com.solvd.bankjdbc.models.FixedTermDeposit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

public class FixedTermDepositDAO extends AbstractMySQL implements IFixedTermDepositDAO {

    private static final Logger logger = LogManager.getLogger(FixedTermDepositDAO.class);

    private static final String CREATE_FIXED_TERM_DEPOSIT = "INSERT INTO FixedTermDeposit (amount, rate, " +
            "from_date, account_id) VALUES (?,?,?,?)";
    private static final String GET_FIXED_TERM_DEPOSIT_BY_ID = "SELECT fixed_term_deposit_id, amount, rate, " +
            "from_date, account_id " +
            "FROM FixedTermDeposit " +
            "WHERE fixed_term_deposit_id = ?";
    private static final String UPDATE_FIXED_TERM_DEPOSIT = "UPDATE FixedTermDeposit SET amount = ?, rate = ?, " +
            "from_date = ?, account_id = ? " +
            "WHERE fixed_term_deposit_id = ?";
    private static final String DELETE_FIXED_TERM_DEPOSIT = "DELETE FROM FixedTermDeposit " +
            "WHERE fixed_term_deposit_id = ?";
    private static final String GET_ALL = "SELECT fixed_term_deposit_id, amount, rate, " +
            "from_date, account_id " +
            "FROM FixedTermDeposit";
    private static final String GET_BY_ACCOUNT_ID = "SELECT fixed_term_deposit_id, amount, rate, " +
            "from_date, account_id " +
            "FROM FixedTermDeposit " +
            "WHERE FixedTermDeposit.account_id = ?";
    @Override
    public void create(FixedTermDeposit fixedTermDeposit) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_FIXED_TERM_DEPOSIT, Statement.RETURN_GENERATED_KEYS);
            ps.setBigDecimal(1, fixedTermDeposit.getAmount());
            ps.setBigDecimal(2, fixedTermDeposit.getRate());
            ps.setDate(3, Date.valueOf(fixedTermDeposit.getFromDate()));
            ps.setInt(4, fixedTermDeposit.getAccountId());
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
    public FixedTermDeposit getById(int id) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FixedTermDeposit fixedTermDeposit = new FixedTermDeposit();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_FIXED_TERM_DEPOSIT_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            fixedTermDeposit.setId(rs.getInt("fixed_term_deposit_id"));
            fixedTermDeposit.setAmount(rs.getBigDecimal("amount"));
            fixedTermDeposit.setRate(rs.getBigDecimal("rate"));
            fixedTermDeposit.setFromDate(rs.getDate("from_date").toLocalDate());
            fixedTermDeposit.setAccountId(rs.getInt("account_id"));
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
        return fixedTermDeposit;
    }

    @Override
    public void update(FixedTermDeposit fixedTermDeposit) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_FIXED_TERM_DEPOSIT, Statement.RETURN_GENERATED_KEYS);
            ps.setBigDecimal(1, fixedTermDeposit.getAmount());
            ps.setBigDecimal(2, fixedTermDeposit.getRate());
            ps.setDate(3, Date.valueOf(fixedTermDeposit.getFromDate()));
            ps.setInt(4, fixedTermDeposit.getAccountId());
            ps.setInt(5, fixedTermDeposit.getId());
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
            ps = c.prepareStatement(DELETE_FIXED_TERM_DEPOSIT, Statement.RETURN_GENERATED_KEYS);
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
    public Set<FixedTermDeposit> getAll() {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<FixedTermDeposit> fixedTermDepositTreeSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_ALL, Statement.RETURN_GENERATED_KEYS);
            rs = ps.executeQuery();

            while (rs.next()){
                FixedTermDeposit fixedTermDeposit = new FixedTermDeposit();
                fixedTermDeposit.setId(rs.getInt("fixed_term_deposit_id"));
                fixedTermDeposit.setAmount(rs.getBigDecimal("amount"));
                fixedTermDeposit.setRate(rs.getBigDecimal("rate"));
                fixedTermDeposit.setFromDate(rs.getDate("from_date").toLocalDate());
                fixedTermDeposit.setAccountId(rs.getInt("account_id"));
                fixedTermDepositTreeSet.add(fixedTermDeposit);
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
        return fixedTermDepositTreeSet;
    }

    @Override
    public Set<FixedTermDeposit> getByAccountId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<FixedTermDeposit> fixedTermDepositTreeSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_ACCOUNT_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()){
                FixedTermDeposit fixedTermDeposit = new FixedTermDeposit();
                fixedTermDeposit.setId(rs.getInt("fixed_term_deposit_id"));
                fixedTermDeposit.setAmount(rs.getBigDecimal("amount"));
                fixedTermDeposit.setRate(rs.getBigDecimal("rate"));
                fixedTermDeposit.setFromDate(rs.getDate("from_date").toLocalDate());
                fixedTermDeposit.setAccountId(rs.getInt("account_id"));
                fixedTermDepositTreeSet.add(fixedTermDeposit);
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
        return fixedTermDepositTreeSet;
    }
}
