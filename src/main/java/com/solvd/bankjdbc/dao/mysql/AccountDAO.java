package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.IAccountDAO;
import com.solvd.bankjdbc.models.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class AccountDAO extends AbstractMySQL implements IAccountDAO {

    private static final Logger logger = LogManager.getLogger(AccountDAO.class);
    private static final String CREATE_ACCOUNT = "INSERT INTO Account (balance, account_type_id, " +
            "account_status_id, account_number_id) VALUES (?,?,?)";
    private static final String GET_ACCOUNT_BY_ID = "SELECT Account.*, " +
            "AccountType.account_type_description, " +
            "AccountStatus.account_status, " +
            "AccountNumber.account_number, " +
            "CustomerAccount.customer_id, " +
            "AccountUserLogin.user_login_id, "  +
            "Card.id, "  +
            "Loan.id, "  +
            "FixedTermDeposit.id, "  +
            "FROM Accounts " +
            "LEFT JOIN ON Account.account_type_id = AccountType.id " +
            "LEFT JOIN ON Account.account_status_id = AccountStatus.id " +
            "LEFT JOIN ON Account.account_number_id = AccountNumber.id " +
            "LEFT JOIN ON Account.id = CustomerAccount.account_id " +
            "LEFT JOIN ON Account.id = AccountUserLogin.account_id " +
            "LEFT JOIN ON Account.id = Card.account_id " +
            "LEFT JOIN ON Account.id = Loan.account_id " +
            "LEFT JOIN ON Account.id = FixedTermDeposit.account_id " +
            "WHERE Account.id = ?";
    private static final String UPDATE_ACCOUNT = "UPDATE Account SET balance = ?, account_type_id = ?, " +
            "account_status_type_id = ?, account_number_id = ? WHERE id = ?";
    private static final String DELETE_ACCOUNT = "DELETE FROM Account WHERE id = ?";
    private static final String GET_BY_TYPE_ID = "SELECT * FROM Account WHERE account_type_id = ?";
    private static final String GET_BY_STATUS_ID = "SELECT * FROM Account WHERE account_status_type_id = ?";
    private static final String GET_BY_ACCOUNT_NUMBER_ID = "SELECT * FROM Account WHERE account_number_id = ?";
    @Override
    public void create(Account account) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_ACCOUNT, Statement.RETURN_GENERATED_KEYS);
            ps.setBigDecimal(1, account.getBalance());
            ps.setInt(2, account.getAccountTypeID());
            ps.setInt(3,account.getAccountStatusID());
            ps.setInt(4, account.getAccountNumberID());
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
    public Account getById(int id) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account account = new Account();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_ACCOUNT_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            account.setId(rs.getInt("id"));
            account.setBalance(rs.getBigDecimal("balance"));
            account.setAccountTypeID(rs.getInt("account_type_id"));
            account.setAccountStatusID(rs.getInt("account_status_id"));
            account.setAccountNumberID(rs.getInt("account_number_id"));
            account.setAccountType(rs.getString("account_type"));
            account.setAccountStatus(rs.getString("account_status"));
            account.setAccountNumber(rs.getString("account_number"));
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
        return account;
    }

    @Override
    public void update(Account account) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_ACCOUNT, Statement.RETURN_GENERATED_KEYS);
            ps.setBigDecimal(1, account.getBalance());
            ps.setInt(2, account.getAccountTypeID());
            ps.setInt(3,account.getAccountStatusID());
            ps.setInt(4, account.getAccountNumberID());
            ps.setInt(5, account.getId());
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

    }
    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public List<Account> getByTypeId(int typeId) {
        return null;
    }

    @Override
    public List<Account> getByStatusId(int statusId) {
        return null;
    }

    @Override
    public Account getByAccountNumberId(int accountNumberId) {
        return null;
    }
}
