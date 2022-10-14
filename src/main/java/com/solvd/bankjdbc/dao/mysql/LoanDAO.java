package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.ILoanDAO;
import com.solvd.bankjdbc.models.Loan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

public class LoanDAO extends AbstractMySQL implements ILoanDAO {

    private static final Logger logger = LogManager.getLogger(LoanDAO.class);

    private static final String CREATE_LOAN = "INSERT INTO Loan (amount, rate, " +
            "returned_amount, from_date, account_id) VALUES (?,?,?,?,?)";
    private static final String GET_LOAN_BY_ID = "SELECT loan_id, amount, rate, " +
            "returned_amount, from_date, account_id " +
            "FROM Loan " +
            "WHERE loan_id = ?";
    private static final String UPDATE_LOAN = "UPDATE Loan SET amount = ?, rate = ?, " +
            "returned_amount = ?, from_date = ?, account_id = ? WHERE loan_id = ?";
    private static final String DELETE_LOAN = "DELETE FROM Loan " +
            "WHERE loan_id = ?";
    private static final String GET_ALL = "SELECT loan_id, amount, rate, " +
            "returned_amount, from_date, account_id " +
            "FROM Loan";
    private static final String GET_BY_ACCOUNT_ID = "SELECT loan_id, amount, rate, " +
            "returned_amount, from_date, account_id " +
            "FROM Loan " +
            "WHERE Loan.account_id = ?";
    @Override
    public void create(Loan loan) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_LOAN, Statement.RETURN_GENERATED_KEYS);
            ps.setBigDecimal(1, loan.getAmount());
            ps.setBigDecimal(2, loan.getRate());
            ps.setBigDecimal(3, loan.getReturnedAmount());
            ps.setDate(4, Date.valueOf(loan.getFromDate()));
            ps.setInt(5, loan.getAccountId());
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
    public Loan getById(int id) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Loan loan = new Loan();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_LOAN_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            loan.setId(rs.getInt("loan_id"));
            loan.setAmount(rs.getBigDecimal("amount"));
            loan.setRate(rs.getBigDecimal("rate"));
            loan.setReturnedAmount(rs.getBigDecimal("returned_amount"));
            loan.setFromDate(rs.getDate("from_date").toLocalDate());
            loan.setAccountId(rs.getInt("account_id"));
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
        return loan;
    }

    @Override
    public void update(Loan loan) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_LOAN, Statement.RETURN_GENERATED_KEYS);
            ps.setBigDecimal(1, loan.getAmount());
            ps.setBigDecimal(2, loan.getRate());
            ps.setBigDecimal(3, loan.getReturnedAmount());
            ps.setDate(4, Date.valueOf(loan.getFromDate()));
            ps.setInt(5, loan.getAccountId());
            ps.setInt(6,loan.getId());
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
            ps = c.prepareStatement(DELETE_LOAN, Statement.RETURN_GENERATED_KEYS);
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
    public Set<Loan> getAll() {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<Loan> loanTreeSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_ALL, Statement.RETURN_GENERATED_KEYS);
            rs = ps.executeQuery();

            while (rs.next()){
                Loan loan = new Loan();
                loan.setId(rs.getInt("loan_id"));
                loan.setAmount(rs.getBigDecimal("amount"));
                loan.setRate(rs.getBigDecimal("rate"));
                loan.setReturnedAmount(rs.getBigDecimal("returned_amount"));
                loan.setFromDate(rs.getDate("from_date").toLocalDate());
                loan.setAccountId(rs.getInt("account_id"));
                loanTreeSet.add(loan);
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
        return loanTreeSet;
    }

    @Override
    public Set<Loan> getByAccountId(int accountId) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<Loan> loanTreeSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_ACCOUNT_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, accountId);
            rs = ps.executeQuery();

            while (rs.next()){
                Loan loan = new Loan();
                loan.setId(rs.getInt("loan_id"));
                loan.setAmount(rs.getBigDecimal("amount"));
                loan.setRate(rs.getBigDecimal("rate"));
                loan.setReturnedAmount(rs.getBigDecimal("returned_amount"));
                loan.setFromDate(rs.getDate("from_date").toLocalDate());
                loan.setAccountId(rs.getInt("account_id"));
                loanTreeSet.add(loan);
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
        return loanTreeSet;
    }
}
