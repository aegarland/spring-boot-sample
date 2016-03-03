package com.aegarland.sample.vending.payment.domain;

import com.aegarland.sample.vending.domain.Currency;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by aeg on 3/2/2016.
 */
public class Coin {

    private final double weight;
    private final double width;
    private final double diameter;
    private final Currency currency;
    private final int units;

    public Coin(double weight, double width, double diameter, Currency currency, int units) {
        this.weight = weight;
        this.width = width;
        this.diameter = diameter;
        this.currency = currency;
        this.units = units;
    }

    public double getWeight() {
        return weight;
    }

    public double getWidth() {
        return width;
    }

    public double getDiameter() {
        return diameter;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getUnits() {
        return units;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Coin coin = (Coin) o;

        return new EqualsBuilder()
                .append(getUnits(), coin.getUnits())
                .append(getCurrency(), coin.getCurrency())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getCurrency())
                .append(getUnits())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Coin{" +
                "weight=" + weight +
                ", width=" + width +
                ", diameter=" + diameter +
                ", currency='" + currency + '\'' +
                ", units=" + units +
                '}';
    }
}
