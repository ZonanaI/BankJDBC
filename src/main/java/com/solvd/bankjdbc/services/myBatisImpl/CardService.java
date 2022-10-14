package com.solvd.bankjdbc.services.myBatisImpl;

import com.solvd.bankjdbc.dao.ICardDAO;
import com.solvd.bankjdbc.models.Card;
import com.solvd.bankjdbc.services.ICardService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Set;

public class CardService implements ICardService {

    private final static SqlSessionFactory sqlSessionFactory = MyBatisFactory.getSqlSessionFactory();
    @Override
    public void create(Card card) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            ICardDAO cardDAO = session.getMapper(ICardDAO.class);
            cardDAO.create(card);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Card getById(int id) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ICardDAO cardDAO = session.getMapper(ICardDAO.class);
            return cardDAO.getById(id);
        }
    }

    @Override
    public void update(Card card) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            ICardDAO cardDAO = session.getMapper(ICardDAO.class);
            cardDAO.update(card);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public void remove(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            ICardDAO cardDAO = session.getMapper(ICardDAO.class);
            cardDAO.remove(id);
            session.commit();
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Card getByCardNumber(String cardNumber) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ICardDAO cardDAO = session.getMapper(ICardDAO.class);
            return cardDAO.getByCardNumber(cardNumber);
        }
    }

    @Override
    public Set<Card> getByAccountId(int accountId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ICardDAO cardDAO = session.getMapper(ICardDAO.class);
            return cardDAO.getByAccountId(accountId);
        }
    }
}
