package com.aegarland.sample.vending.service;

import com.aegarland.sample.vending.domain.Currency;
import com.aegarland.sample.vending.event.VendingMachineEvent;
import com.aegarland.sample.vending.payment.domain.InputObject;
import org.springframework.context.ApplicationListener;

/**
 * Created by aeg on 3/2/2016.
 */
public interface PaymentModule extends ApplicationListener<VendingMachineEvent<InputObject>> {
    boolean completeSale(Currency currency, int price);
    boolean cancelSale();
    int getBalance();
}
