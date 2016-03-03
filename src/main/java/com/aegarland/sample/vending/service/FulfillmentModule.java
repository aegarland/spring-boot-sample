package com.aegarland.sample.vending.service;

import com.aegarland.sample.vending.event.VendingMachineEvent;
import com.aegarland.sample.vending.fulfillment.domain.Product;
import org.springframework.context.ApplicationListener;

import java.util.Optional;

/**
 * Created by aeg on 3/2/2016.
 */
public interface FulfillmentModule extends ApplicationListener<VendingMachineEvent> {
    Optional<Product> getProduct(String slotlabel);
    boolean sell(String slotlabel);
}
