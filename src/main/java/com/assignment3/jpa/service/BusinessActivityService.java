package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.BusinessActivityDao;
import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Card;
import com.assignment3.jpa.model.Place;

public class BusinessActivityService extends AbstractService<BusinessActivity, Long> {

    CardService cardService;

    public BusinessActivityService() {
        super(new BusinessActivityDao());
    }

    public void addPlace(BusinessActivity businessActivity, Place place) {
        getDao().begin();
        businessActivity.addPlace(place);
        getDao().commit();
    }

    public void removePlace(BusinessActivity businessActivity) {
        Place place = businessActivity.getPlace();
        getDao().begin();
        if (place != null)
            businessActivity.removePlace();
        getDao().commit();
    }

    public void addCard(BusinessActivity businessActivity, Card card) {
        getDao().begin();
        businessActivity.addCard(card);
        getDao().commit();
    }

    public void removeCard(Card card) {
        BusinessActivity businessActivity = card.getBusinessActivity();
        getDao().begin();
        if (businessActivity != null)
            businessActivity.removeCard(card);
        getDao().commit();
        /*cardService = ServiceFactory.getInstance().getCardService();
        cardService.delete(card);*/
    }

    public void removeAllCard(BusinessActivity businessActivity) {
        getDao().begin();
        if (businessActivity != null)
            businessActivity.removeAllCard();
        getDao().commit();
    }

    @Override
    public void delete(BusinessActivity b) {
        removePlace(b);
        removeAllCard(b);
        getDao().begin();
        getDao().delete(b);
        getDao().commit();
    }
}
