package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.Place;

public class PlaceDao extends AbstractDao<Place, Long, String> {

    public PlaceDao() { super(Place.class); }
}
