package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.IAccountDAO;
import com.solvd.bankjdbc.models.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class AccountDAO extends AbstractMySQL implements IAccountDAO {

    private static final Logger logger = LogManager.getLogger(AccountDAO.class);
    private static final String CREATE_ACCOUNT = "INSERT INTO Account (balance, account_type_id, " +
            "account_status_id, account_number_id) VALUES (?,?,?)";
    private static final String GET_ACCOUNT_BY_ID = "SELECT Account.account_id, Account.balance, " +
        "Account.account_type_id, Account.account_status_id, Account.account_number_id, " +
        "AccountType.account_type, AccountStatus.account_status, AccountNumber.account_number  " +
        "FROM Account " +
        "LEFT JOIN AccountType ON Account.account_type_id = AccountType.account_type_id " +
        "LEFT JOIN AccountStatus ON Account.account_status_id = AccountStatus.account_status_id " +
        "LEFT JOIN AccountNumber ON Account.account_number_id = AccountNumber.account_number_id " +
        "WHERE Account.account_id = ?";
    private static final String UPDATE_ACCOUNT = "UPDATE Account SET balance = ?, account_type_id = ?, " +
            "account_status_id = ?, account_number_id = ? WHERE account_id = ?";
    private static final String DELETE_ACCOUNT = "DELETE FROM Account WHERE account_id = ?";
    private static final String GET_ALL = "SELECT Account.account_id, Account.balance, " +
            "Account.account_type_id, Account.account_status_id, Account.account_number_id, " +
            "AccountType.account_type, AccountStatus.account_status, AccountNumber.account_number  " +
            "FROM Account" +
            "LEFT JOIN AccountType ON Account.account_type_id = AccountType.account_type_id " +
            "LEFT JOIN AccountStatus ON Account.account_status_id = AccountStatus.account_status_id " +
            "LEFT JOIN AccountNumber ON Account.account_number_id = AccountNumber.account_number_id ";
    private static final String GET_BY_TYPE_ID = "SELECT Account.account_id, Account.balance, " +
            "Account.account_type_id, Account.account_status_id, Account.account_number_id, " +
            "AccountType.account_type, AccountStatus.account_status, AccountNumber.account_number  " +
            "FROM Account" +
            "LEFT JOIN AccountType ON Account.account_type_id = AccountType.account_type_id " +
            "LEFT JOIN AccountStatus ON Account.account_status_id = AccountStatus.account_status_id " +
            "LEFT JOIN AccountNumber ON Account.account_number_id = AccountNumber.account_number_id " +
            "WHERE account_type_id = ?";
    private static final String GET_BY_STATUS_ID = "SELECT Account.account_id, Account.balance, " +
            "Account.account_type_id, Account.account_status_id, Account.account_number_id, " +
            "AccountType.account_type, AccountStatus.account_status, AccountNumber.account_number  " +
            "FROM Account" +
            "LEFT JOIN AccountType ON Account.account_type_id = AccountType.account_type_id " +
            "LEFT JOIN AccountStatus ON Account.account_status_id = AccountStatus.account_status_id " +
            "LEFT JOIN AccountNumber ON Account.account_number_id = AccountNumber.account_number_id " +
            "WHERE account_status_type_id = ?";
    private static final String GET_BY_ACCOUNT_NUMBER_ID = "SELECT Account.account_id, Account.balance, " +
            "Account.account_type_id, Account.account_status_id, Account.account_number_id, " +
            "AccountType.account_type, AccountStatus.account_status, AccountNumber.account_number  " +
            "FROM Account" +
            "LEFT JOIN AccountType ON Account.account_type_id = AccountType.account_type_id " +
            "LEFT JOIN AccountStatus ON Account.account_status_id = AccountStatus.account_status_id " +
            "LEFT JOIN AccountNumber ON Account.account_number_id = AccountNumber.account_number_id " +
            "WHERE account_number_id = ?";
    private static final String GET_BY_CUSTOMER_ID = "SELECT Account.account_id, Account.balance, " +
            "Account.account_type_id, Account.account_status_id, Account.account_number_id, " +
            "AccountType.account_type, AccountStatus.account_status, AccountNumber.account_number  " +
            "FROM Account" +
            "LEFT JOIN AccountType ON Account.account_type_id = AccountType.account_type_id " +
            "LEFT JOIN AccountStatus ON Account.account_status_id = AccountStatus.account_status_id " +
            "LEFT JOIN AccountNumber ON Account.account_number_id = AccountNumber.account_number_id " +
            "INNER JOIN CustomerAccount ON account.account_id = CustomerAccount.account_id " +
            "WHERE CustomerAccount.customer_id = ?";
    private static final String GET_BY_USER_LOGIN_ID = "SELECT Account.account_id, Account.balance, " +
            "Account.account_type_id, Account.account_status_id, Account.account_number_id, " +
            "AccountType.account_type, AccountStatus.account_status, AccountNumber.account_number  " +
            "FROM Account" +
            "LEFT JOIN AccountType ON Account.account_type_id = AccountType.account_type_id " +
            "LEFT JOIN AccountStatus ON Account.account_status_id = AccountStatus.account_status_id " +
            "LEFT JOIN AccountNumber ON Account.account_number_id = AccountNumber.account_number_id " +
            "INNER JOIN AccountUserLogin ON Account.account_id = AccountUserLogin.account_id " +
            "WHERE AccountUserLogin.user_login_id = ?";
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
            ps.setInt(3, account.getAccountStatusID());
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
            account.setId(rs.getInt("account_id"));
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
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(DELETE_ACCOUNT, Statement.RETURN_GENERATED_KEYS);
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
    public Set<Account> getAll() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<Account> accountSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_ALL, Statement.RETURN_GENERATED_KEYS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("account_id"));
                account.setBalance(rs.getBigDecimal("balance"));
                account.setAccountTypeID(rs.getInt("account_type_id"));
                account.setAccountStatusID(rs.getInt("account_status_id"));
                account.setAccountNumberID(rs.getInt("account_number_id"));
                account.setAccountType(rs.getString("account_type"));
                account.setAccountStatus(rs.getString("account_status"));
                account.setAccountNumber(rs.getString("account_number"));
                accountSet.add(account);
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
        return accountSet;
    }

    @Override
    public Set<Account> getByTypeId(int typeId) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<Account> accountSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_TYPE_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, typeId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("account_id"));
                account.setBalance(rs.getBigDecimal("balance"));
                account.setAccountTypeID(rs.getInt("account_type_id"));
                account.setAccountStatusID(rs.getInt("account_status_id"));
                account.setAccountNumberID(rs.getInt("account_number_id"));
                account.setAccountType(rs.getString("account_type"));
                account.setAccountStatus(rs.getString("account_status"));
                account.setAccountNumber(rs.getString("account_number"));
                accountSet.add(account);
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
        return accountSet;
    }

    @Override
    public Set<Account> getByStatusId(int statusId) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<Account> accountSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_STATUS_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, statusId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("account_id"));
                account.setBalance(rs.getBigDecimal("balance"));
                account.setAccountTypeID(rs.getInt("account_type_id"));
                account.setAccountStatusID(rs.getInt("account_status_id"));
                account.setAccountNumberID(rs.getInt("account_number_id"));
                account.setAccountType(rs.getString("account_type"));
                account.setAccountStatus(rs.getString("account_status"));
                account.setAccountNumber(rs.getString("account_number"));
                accountSet.add(account);
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
        return accountSet;
    }

    @Override
    public Set<Account> getByCustomerId(int customerId) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<Account> accountSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_CUSTOMER_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customerId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("account_id"));
                account.setBalance(rs.getBigDecimal("balance"));
                account.setAccountTypeID(rs.getInt("account_type_id"));
                account.setAccountStatusID(rs.getInt("account_status_id"));
                account.setAccountNumberID(rs.getInt("account_number_id"));
                account.setAccountType(rs.getString("account_type"));
                account.setAccountStatus(rs.getString("account_status"));
                account.setAccountNumber(rs.getString("account_number"));
                accountSet.add(account);
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
        return accountSet;
    }

    @Override
    public Set<Account> getByUserLoginId(int userLoginId) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<Account> accountSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_USER_LOGIN_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userLoginId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("account_id"));
                account.setBalance(rs.getBigDecimal("balance"));
                account.setAccountTypeID(rs.getInt("account_type_id"));
                account.setAccountStatusID(rs.getInt("account_status_id"));
                account.setAccountNumberID(rs.getInt("account_number_id"));
                account.setAccountType(rs.getString("account_type"));
                account.setAccountStatus(rs.getString("account_status"));
                account.setAccountNumber(rs.getString("account_number"));
                accountSet.add(account);
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
        return accountSet;
    }

    @Override
    public Account getByAccountNumberId(int accountNumberId) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account account = new Account();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_ACCOUNT_NUMBER_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, accountNumberId);
            rs = ps.executeQuery();
            rs.next();
            account.setId(rs.getInt("account_id"));
            account.setBalance(rs.getBigDecimal("balance"));
            account.setAccountTypeID(rs.getInt("account_type_id"));
            account.setAccountStatusID(rs.getInt("account_status_id"));
            account.setAccountNumberID(rs.getInt("account_number_id"));
            account.setAccountType(rs.getString("account_type"));
            account.setAccountStatus(rs.getString("account_status"));
            account.setAccountNumber(rs.getString("account_number"));
            }
         catch (SQLException e) {
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
}
