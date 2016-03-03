package com.aegarland.sample.vending.fulfillment.domain;

import com.aegarland.sample.vending.domain.Currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static java.lang.Enum.valueOf;

/**
 * Created by aeg on 3/2/2016.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String currency;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private String description;

    public Currency getCurrency() {
        return valueOf(Currency.class,currency);
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    protected Product() {
    }

    public Product(String currency, int price, String description) {
        this.currency = currency;
        this.price = price;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }
}
