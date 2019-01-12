package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.Card;
import com.assignment3.jpa.model.SharableCard;
import com.assignment3.jpa.model.StandardCard;

import java.util.List;

public class CardDao extends AbstractDao<Card, Long, String> {

    public CardDao() {
        super(Card.class);
    }

    public List<StandardCard> getStandardCards() {
        return getEntityManager().createQuery("SELECT c FROM Card c WHERE TYPE = 'ST'").getResultList();
    }

    public List<SharableCard> getSharableCards() {
        return getEntityManager().createQuery("SELECT c FROM Card c WHERE TYPE = 'SH'").getResultList();
    }
}

