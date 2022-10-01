package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.IUserSecurityQuestionDAO;
import com.solvd.bankjdbc.models.UserSecurityQuestion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

public class UserSecurityQuestionDAO extends AbstractMySQL implements IUserSecurityQuestionDAO {

    private static final Logger logger = LogManager.getLogger(UserSecurityQuestionDAO.class);

    private static final String CREATE_USER_SECURITY_QUESTION = "INSERT INTO UserSecurityQuestion " +
            "(user_security_question, user_login_id) VALUES (?,?)";
    private static final String GET_USER_SECURITY_QUESTION_BY_ID = "SELECT USQ.user_security_question_id, " +
            "USQ.user_security_question, USQ.user_login_id, USA.user_security_answer " +
            "FROM UserSecurityQuestion AS USQ " +
            "INNER JOIN UserSecurityAnswer AS USA ON USQ.user_security_question_id = USA.user_security_question_id " +
            "WHERE USQ.user_security_question_id = ?";
    private static final String UPDATE_USER_SECURITY_QUESTION = "UPDATE UserSecurityQuestion " +
            "SET user_security_question = ?, user_login_id = ? " +
            "WHERE user_security_question_id = ?";
    private static final String DELETE_USER_SECURITY_QUESTION = "DELETE FROM UserSecurityQuestion " +
            "WHERE user_security_question_id = ?";
    private static final String GET_BY_USER_LOGIN_ID = "SELECT USQ.user_security_question_id, " +
            "USQ.user_security_question, USQ.user_login_id, USA.user_security_answer " +
            "FROM UserSecurityQuestion AS USQ " +
            "INNER JOIN UserSecurityAnswer AS USA ON USQ.user_security_question_id = USA.user_security_question_id " +
            "INNER JOIN UserLogin ON USQ.user_login_id = UserLogin.user_login_id " +
            "WHERE UserLogin.user_login_id = ?";
    
    @Override
    public void create(UserSecurityQuestion userSecurityQuestion) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_USER_SECURITY_QUESTION, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, userSecurityQuestion.getSecurityQuestion());
            ps.setInt(2, userSecurityQuestion.getUserLoginId());
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
    public UserSecurityQuestion getById(int id) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserSecurityQuestion userSecurityQuestion = new UserSecurityQuestion();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_USER_SECURITY_QUESTION_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            userSecurityQuestion.setId(rs.getInt("user_security_question_id"));
            userSecurityQuestion.setSecurityQuestion(rs.getString("user_security_question"));
            userSecurityQuestion.setUserLoginId(rs.getInt("user_login_id"));
            userSecurityQuestion.setSecurityAnswer(rs.getString("user_security_answer"));
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
        return userSecurityQuestion;    }

    @Override
    public void update(UserSecurityQuestion userSecurityQuestion) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_USER_SECURITY_QUESTION, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, userSecurityQuestion.getSecurityQuestion());
            ps.setInt(2, userSecurityQuestion.getUserLoginId());
            ps.setInt(3,userSecurityQuestion.getId());
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
            ps = c.prepareStatement(DELETE_USER_SECURITY_QUESTION, Statement.RETURN_GENERATED_KEYS);
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
    public Set<UserSecurityQuestion> getByUserLoginId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<UserSecurityQuestion> userSecurityQuestionTreeSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_USER_LOGIN_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            while (rs.next()){
                UserSecurityQuestion userSecurityQuestion = new UserSecurityQuestion();
                userSecurityQuestion.setId(rs.getInt("user_security_question_id"));
                userSecurityQuestion.setSecurityQuestion(rs.getString("user_security_question"));
                userSecurityQuestion.setUserLoginId(rs.getInt("user_login_id"));
                userSecurityQuestion.setSecurityAnswer(rs.getString("user_security_answer"));
                userSecurityQuestionTreeSet.add(userSecurityQuestion);
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
        return userSecurityQuestionTreeSet;
    }
}
