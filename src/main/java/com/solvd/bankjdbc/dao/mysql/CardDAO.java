package com.solvd.bankjdbc.dao.mysql;

import com.solvd.bankjdbc.dao.ICardDAO;
import com.solvd.bankjdbc.models.Card;

import java.util.Set;

public class CardDAO extends AbstractMySQL implements ICardDAO {

    @Override
    public void create(Card object) {

    }

    @Override
    public Card getById(int id) {
        return null;
    }

    @Override
    public void update(Card object) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Card getByCardNumber(String cardNumber) {
        return null;
    }

    @Override
    public Set<Card> getByAccountId(int accountId) {
        return null;
    }
}
