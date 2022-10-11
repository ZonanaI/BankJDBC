package com.solvd.bankjdbc.services;

import com.solvd.bankjdbc.models.Card;

import java.util.Set;

public interface ICardService extends IBaseService<Card> {
    public Card getByCardNumber(String cardNumber);
    public Set<Card> getByAccountId(int accountId);
}
