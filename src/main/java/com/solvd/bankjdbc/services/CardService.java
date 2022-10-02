package com.solvd.bankjdbc.services;

import com.solvd.bankjdbc.dao.ICardDAO;
import com.solvd.bankjdbc.dao.mysql.CardDAO;
import com.solvd.bankjdbc.models.Card;

import java.util.Set;

public class CardService {
    private final ICardDAO cardDAO = new CardDAO();

    public void create(Card card) {
        cardDAO.create(card);
    }

    public Card getById(int id) {
        return cardDAO.getById(id);
    }

    public void update(Card card) {
        cardDAO.update(card);
    }

    public void remove(int id) {
        cardDAO.remove(id);
    }

    public Card getByCardNumber(String cardNumber) {
        return cardDAO.getByCardNumber(cardNumber);
    }

    public Set<Card> getByAccountId(int accountId) {
        return cardDAO.getByAccountId(accountId);
    }
}
