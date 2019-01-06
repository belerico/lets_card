package com.assignment3.jpa.service;

import com.assignment3.jpa.Helper;
import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Place;
import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BusinessActivityServiceTest {

    private static Faker faker;
    private static BusinessActivityService businessActivityService;

    @AfterClass
    public static void dropDb() {
        Helper.dropDatabase();
    }

    @Before
    public void before() {
        Helper.dropDatabase();
        //Helper.resetIdAutoIncrement(BusinessActivity.class);
        faker = new Faker(new Locale("it"));
        businessActivityService = new BusinessActivityService();
    }

    private BusinessActivity createBusinessActivityWithPlace() {
        BusinessActivity businessActivity = new BusinessActivity();
        businessActivity.setName(faker.company().name());
        businessActivity.setType(faker.company().profession());
        Place place = new Place();
        place.setCity(faker.address().city());
        place.setCAP(faker.address().zipCode());
        place.setRegion(faker.address().state());
        place.setProvince(faker.address().country());
        businessActivity.addPlace(place);
        businessActivityService.create(businessActivity);
        return businessActivity;
    }

    private BusinessActivity createBusinessActivity() {
        BusinessActivity businessActivity = new BusinessActivity();
        businessActivity.setName(faker.company().name());
        businessActivity.setType(faker.company().profession());
        businessActivityService.create(businessActivity);
        return businessActivity;
    }

    @Test
    public void create() {
        BusinessActivity businessActivity = createBusinessActivity();
        assertNotNull(businessActivity.getId());
    }

    @Test
    public void read() {
        BusinessActivity businessActivity = createBusinessActivity();
        businessActivity = businessActivityService.read(businessActivity.getId());
        assertNotNull(businessActivity);
        assertNotNull(businessActivity.getName());
        assertNotNull(businessActivity.getType());
    }

    @Test
    public void update() {
        BusinessActivity businessActivity = createBusinessActivity();
        businessActivity.setType("Test");
        businessActivity = businessActivityService.update(businessActivity);
        BusinessActivity newBusinessActivity = businessActivityService.read(businessActivity.getId());
        assertEquals(newBusinessActivity.getType(), "Test");
    }

    @Test
    public void readAll() {
        createBusinessActivity();
        createBusinessActivity();
        List<BusinessActivity> list = businessActivityService.readAll();
        assertEquals(list.size(), 2);
    }

    @Test
    public void deleteAll() {
        createBusinessActivity();
        createBusinessActivity();
        businessActivityService.deleteAll();
        List<BusinessActivity> list = businessActivityService.readAll();
        assertEquals(list.size(), 0);
    }

    @Test
    public void addPlace() {

    }

    @Test
    public void removePlace() {
    }

    @Test
    public void addCard() {
    }

    @Test
    public void removeCard() {
    }

    @Test
    public void removeAllCard() {
    }

    @Test
    public void delete() {
    }
}