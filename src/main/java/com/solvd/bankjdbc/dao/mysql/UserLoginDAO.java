package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.IUserLoginDAO;
import com.solvd.bankjdbc.models.UserLogin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

public class UserLoginDAO extends AbstractMySQL implements IUserLoginDAO {

    private static final Logger logger = LogManager.getLogger(UserLoginDAO.class);

    private static final String CREATE_USER_LOGIN = "INSERT INTO UserLogin (user_password, user_name_id)" +
            " VALUES (?,?)";
    private static final String GET_USER_LOGIN_BY_ID = "SELECT UserLogin.user_login_id, UserLogin.user_password, " +
            "UserLogin.user_name_id, UserName.user_name " +
            "FROM UserLogin " +
            "INNER JOIN UserName ON UserLogin.user_name_id = UserName.user_name_id " +
            "WHERE user_login_id = ?";
    private static final String UPDATE_USER_LOGIN = "UPDATE UserLogin SET user_password = ?, card_number_id = ? " +
            "WHERE user_login_id = ?";
    private static final String DELETE_USER_LOGIN = "DELETE FROM UserLogin WHERE user_login_id = ?";
    private static final String GET_BY_USER_LOGIN_NAME = "SELECT UserLogin.user_login_id, UserLogin.user_password, " +
            "UserLogin.user_name_id, UserName.user_name " +
            "FROM UserLogin " +
            "INNER JOIN UserName ON UserLogin.user_name_id = UserName.user_name_id " +
            "WHERE  UserName.user_name = ?";
    private static final String GET_BY_ACCOUNT_NUMBER_ID = "SELECT UserLogin.user_login_id, UserLogin.user_password, " +
            "UserLogin.user_name_id, UserName.user_name " +
            "FROM UserLogin " +
            "INNER JOIN UserName ON UserLogin.user_name_id = UserName.user_name_id " +
            "INNER JOIN AccountUserLogin ON UserLogin.user_login_id = AccountUserLogin.user_login_id " +
            "WHERE  AccountUserLogin.account_id = ?";
    private static final String GET_ALL = "SELECT UserLogin.user_login_id, UserLogin.user_password, " +
            "UserLogin.user_name_id, UserName.user_name " +
            "FROM UserLogin " +
            "INNER JOIN UserName ON UserLogin.user_name_id = UserName.user_name_id ";

    @Override
    public void create(UserLogin userLogin) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_USER_LOGIN, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, userLogin.getPassword());
            ps.setInt(2, userLogin.getUserNameId());
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
    public UserLogin getById(int id) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserLogin userLogin = new UserLogin();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_USER_LOGIN_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            userLogin.setId(rs.getInt("user_login_id"));
            userLogin.setPassword(rs.getString("user_password"));
            userLogin.setUserNameId(rs.getInt("user_name_id"));
            userLogin.setUsername(rs.getString("user_name"));
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
        return userLogin;
    }

    @Override
    public void update(UserLogin userLogin) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_USER_LOGIN, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, userLogin.getPassword());
            ps.setInt(2, userLogin.getUserNameId());
            ps.setInt(3,userLogin.getId());
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
            ps = c.prepareStatement(DELETE_USER_LOGIN, Statement.RETURN_GENERATED_KEYS);
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
    public Set<UserLogin> getAll() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<UserLogin> userLoginTreeSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_ALL, Statement.RETURN_GENERATED_KEYS);
            rs = ps.executeQuery();

            while (rs.next()){
                UserLogin userLogin = new UserLogin();
                userLogin.setId(rs.getInt("user_login_id"));
                userLogin.setPassword(rs.getString("user_password"));
                userLogin.setUserNameId(rs.getInt("user_name_id"));
                userLogin.setUsername(rs.getString("user_name"));
                userLoginTreeSet.add(userLogin);
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
        return userLoginTreeSet;
    }
    @Override
    public UserLogin getByUserName(String userName) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserLogin userLogin = new UserLogin();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_USER_LOGIN_NAME, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            rs.next();
            userLogin.setId(rs.getInt("user_login_id"));
            userLogin.setPassword(rs.getString("user_password"));
            userLogin.setUserNameId(rs.getInt("user_name_id"));
            userLogin.setUsername(rs.getString("user_name"));
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
        return userLogin;
    }

    @Override
    public Set<UserLogin> getByAccountId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<UserLogin> userLoginTreeSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_ACCOUNT_NUMBER_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            while (rs.next()){
                UserLogin userLogin = new UserLogin();
                userLogin.setId(rs.getInt("user_login_id"));
                userLogin.setPassword(rs.getString("user_password"));
                userLogin.setUserNameId(rs.getInt("user_name_id"));
                userLogin.setUsername(rs.getString("user_name"));
                userLoginTreeSet.add(userLogin);
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
        return userLoginTreeSet;
    }
}
