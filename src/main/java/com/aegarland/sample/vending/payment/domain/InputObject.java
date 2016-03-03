package com.aegarland.sample.vending.payment.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by aeg on 3/2/2016.
 */
public class InputObject {

    private double weight;
    private double width;
    private double diameter;

    public InputObject () {}

    public InputObject(double weight, double width, double diameter) {
        this.weight = weight;
        this.width = width;
        this.diameter = diameter;
    }

    @ApiModelProperty(position = 1, required = true, example="7.0")
    public double getWeight() {
        return weight;
    }

    @ApiModelProperty(position = 2, required = true, example="1.7")
    public double getWidth() {
        return width;
    }

    @ApiModelProperty(position = 3, required = true, example="2.5")
    public double getDiameter() {
        return diameter;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "InputObject{" +
                "weight=" + weight +
                ", width=" + width +
                ", diameter=" + diameter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        InputObject that = (InputObject) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(weight, that.weight)
                .append(width, that.width)
                .append(diameter, that.diameter)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(weight)
                .append(width)
                .append(diameter)
                .toHashCode();
    }
}
