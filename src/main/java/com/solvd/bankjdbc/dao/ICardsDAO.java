package com.solvd.bankjdbc.dao;

import com.solvd.bankjdbc.models.Cards;

import java.util.Set;

public interface ICardsDAO extends IBaseDao<Cards>{
    Cards getByCardNumber(long cardNumber);
    Set<Cards> getByAccountId(long accountId);
}
