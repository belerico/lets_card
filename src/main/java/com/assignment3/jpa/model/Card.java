package com.assignment3.jpa.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NaturalId
    private String cardNumber;
    private int quantity;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private BusinessActivity businessActivity;
    @Column(insertable = false, updatable = false) private String type;

    public Card() {
    }

    public Card(String cardNumber, int quantity) {
        this.cardNumber = cardNumber;
        this.quantity = quantity;
        setType(getDiscriminatorValue());
    }

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Card(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BusinessActivity getBusinessActivity() {
        return businessActivity;
    }

    public void setBusinessActivity(BusinessActivity businessActivity) {
        this.businessActivity = businessActivity;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*public void addBusinessActivity(BusinessActivity businessActivity) {
        setBusinessActivity(businessActivity);
        businessActivity.getCards().add(this);
    }

    public void removeBusinessActivity() {
        setBusinessActivity(null);
        getBusinessActivity().getCards().remove(this);
    }*/

    @Transient
    public String getDiscriminatorValue(){
        DiscriminatorValue val = this.getClass().getAnnotation(DiscriminatorValue.class);
        return val == null ? null : val.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return Objects.equals(cardNumber, card.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", type='"+getDiscriminatorValue()+"'"+
                ", cardNumber='" + cardNumber + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
