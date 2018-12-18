package com.assignment3.jpa.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class BusinessActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*Name of the activity*/
    private String name;
    /*Type of the activity (e.g restaurant, bar, kebabbaro..)*/
    private String type;
    @ManyToOne
    private Place place;
    @OneToMany(mappedBy = "businessActivity", cascade = CascadeType.ALL)
    private Set<Card> cards = new HashSet<>();


    public BusinessActivity() {
    }

    public BusinessActivity(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Place getPlace() {
        return place;
    }

    void setPlace(Place place) {
        this.place = place;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusinessActivity)) return false;
        BusinessActivity that = (BusinessActivity) o;
        return name.equals(that.name) &&
                type.equals(that.type) &&
                place.equals(that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, place);
    }

    @Override
    public String toString() {
        return "BusinessActivity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", place=" + place +
                '}';

    }
}
