package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.Card;

import java.util.Set;

public interface ICardDAO extends IBaseDAO<Card> {
    Card getByCardNumber(String cardNumber);
    Set<Card> getByAccountId(int accountId);
}
