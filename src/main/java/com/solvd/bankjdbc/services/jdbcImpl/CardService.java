package com.solvd.bankjdbc.services.jdbcImpl;

import com.solvd.bankjdbc.dao.ICardDAO;
import com.solvd.bankjdbc.dao.mysql.CardDAO;
import com.solvd.bankjdbc.models.Card;
import com.solvd.bankjdbc.services.ICardService;

import java.util.Set;

public class CardService implements ICardService {
    private final ICardDAO cardDAO = new CardDAO();
    @Override
    public void create(Card card) {
        cardDAO.create(card);
    }
    @Override
    public Card getById(int id) {
        return cardDAO.getById(id);
    }
    @Override
    public void update(Card card) {
        cardDAO.update(card);
    }
    @Override
    public void remove(int id) {
        cardDAO.remove(id);
    }
    @Override
    public Card getByCardNumber(String cardNumber) {
        return cardDAO.getByCardNumber(cardNumber);
    }
    @Override
    public Set<Card> getByAccountId(int accountId) {
        return cardDAO.getByAccountId(accountId);
    }
}
