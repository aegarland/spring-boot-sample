package com.aegarland.sample.vending.fulfillment.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * Created by aeg on 3/2/2016.
 */
@Entity
public class VendingMachineSlot {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(optional = false)
    @NaturalId
    private Product product;

    @Column(nullable = false, unique = true)
    private String slotlabel;

    @Column(nullable = false)
    private int units;

    public Integer getId() {
        return id;
    }

    public String getSlotlabel() {
        return slotlabel;
    }

    public Product getProduct() {
        return product;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    protected VendingMachineSlot() {
    }

    public VendingMachineSlot(String slotlabel, Product product, int units) {
        this.slotlabel = slotlabel;
        this.product = product;
        this.units = units;
    }
}
