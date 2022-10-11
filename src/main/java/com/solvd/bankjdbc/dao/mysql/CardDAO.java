package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.ICardDAO;
import com.solvd.bankjdbc.models.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

public class CardDAO extends AbstractMySQL implements ICardDAO {
    private static final Logger logger = LogManager.getLogger(CardDAO.class);

    private static final String CREATE_CARD = "INSERT INTO Card (exp_date, security_number, " +
            "card_number_id, card_type_id, account_id) VALUES (?,?,?,?,?)";
    private static final String GET_CARD_BY_ID = "SELECT Card.card_id, Card.exp_date, " +
            "Card.security_number,  Card.card_number_id, Card.card_type_id, Card.account_id, " +
            "CardNumber.card_number, CardType.card_type " +
            "FROM Card " +
            "LEFT JOIN CardType ON Card.card_type_id = CardType.card_type_id " +
            "LEFT JOIN CardNumber ON Card.card_number_id =CardNumber.card_number_id " +
            "WHERE Card.card_id = ?";
    private static final String UPDATE_CARD = "UPDATE Card SET exp_date = ?, card_number_id = ?, " +
            "card_type_id = ?, card_number_id = ? WHERE card_id = ?";
    private static final String DELETE_CARD = "DELETE FROM Card WHERE card_id = ?";
    private static final String GET_BY_CARD_NUMBER = "SELECT Card.card_id, Card.exp_date, " +
            "Card.security_number,  Card.card_number_id, Card.card_type_id, Card.account_id, " +
            "CardNumber.card_number, CardType.card_type " +
            "FROM Card " +
            "LEFT JOIN CardType ON Card.card_type_id = CardType.card_type_id " +
            "LEFT JOIN CardNumber ON Card.card_number_id =CardNumber.card_number_id " +
            "WHERE CardNumber.card_number = ?";
    private static final String GET_BY_ACCOUNT_NUMBER_ID = "SELECT Card.card_id, Card.exp_date, " +
            "Card.security_number,  Card.card_number_id, Card.card_type_id, Card.account_id, " +
            "CardNumber.card_number, CardType.card_type " +
            "FROM Card " +
            "LEFT JOIN CardType ON Card.card_type_id = CardType.card_type_id " +
            "LEFT JOIN CardNumber ON Card.card_number_id =CardNumber.card_number_id " +
            "WHERE Card.account_id = ?";
    @Override
    public void create(Card card) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_CARD, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(card.getExpDate()));
            ps.setString(2, card.getSecurityNumber());
            ps.setInt(3, card.getCardNumberId());
            ps.setInt(4, card.getCardTypeId());
            ps.setInt(5, card.getAccountId());
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
    public Card getById(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Card card = new Card();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_CARD_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            card.setId(rs.getInt("card_id"));
            card.setExpDate(rs.getDate("exp_date").toLocalDate());
            card.setSecurityNumber(rs.getString("security_number"));
            card.setCardNumberId(rs.getInt("card_number_id"));
            card.setCardTypeId(rs.getInt("card_type_id"));
            card.setAccountId(rs.getInt("account_id"));
            card.setCardNumber(rs.getString("card_number"));
            card.setCardType(rs.getString("card_type"));
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
        return card;
    }

    @Override
    public void update(Card card) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_CARD, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(card.getExpDate()));
            ps.setString(2, card.getSecurityNumber());
            ps.setInt(3, card.getCardNumberId());
            ps.setInt(4, card.getCardTypeId());
            ps.setInt(5, card.getAccountId());
            ps.setInt(6, card.getId());
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
            ps = c.prepareStatement(DELETE_CARD, Statement.RETURN_GENERATED_KEYS);
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
    public Card getByCardNumber(String cardNumber) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Card card = new Card();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_CARD_NUMBER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cardNumber);
            rs = ps.executeQuery();
            rs.next();
            card.setId(rs.getInt("card_id"));
            card.setExpDate(rs.getDate("exp_date").toLocalDate());
            card.setSecurityNumber(rs.getString("security_number"));
            card.setCardNumberId(rs.getInt("card_number_id"));
            card.setCardTypeId(rs.getInt("card_type_id"));
            card.setAccountId(rs.getInt("account_id"));
            card.setCardNumber(rs.getString("card_number"));
            card.setCardType(rs.getString("card_type"));
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
        return card;
    }

    @Override
    public Set<Card> getByAccountId(int accountId) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<Card> cardSet = new TreeSet<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_BY_ACCOUNT_NUMBER_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, accountId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Card card = new Card();
                card.setId(rs.getInt("card_id"));
                card.setExpDate(rs.getDate("exp_date").toLocalDate());
                card.setSecurityNumber(rs.getString("security_number"));
                card.setCardNumberId(rs.getInt("card_number_id"));
                card.setCardTypeId(rs.getInt("card_type_id"));
                card.setAccountId(rs.getInt("account_id"));
                card.setCardNumber(rs.getString("card_number"));
                card.setCardType(rs.getString("card_type"));
                cardSet.add(card);
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
        return cardSet;
    }
}
