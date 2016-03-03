package com.aegarland.sample.vending.payment;

import com.aegarland.sample.vending.domain.Currency;
import com.aegarland.sample.vending.event.VendingMachineEvent;
import com.aegarland.sample.vending.payment.domain.Coin;
import com.aegarland.sample.vending.payment.domain.InputObject;
import com.aegarland.sample.vending.payment.service.InputObjectClassifier;
import com.aegarland.sample.vending.service.PaymentModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by aeg on 3/2/2016.
 */
@Component
public class PaymentModuleImpl implements PaymentModule {

    @Autowired
    InputObjectClassifier classifier;

    private final ApplicationEventPublisher publisher;

    @Autowired
    public PaymentModuleImpl(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    private Currency allowedCurrency = Currency.USD;
    int balance = 0;

    @Override
    public void onApplicationEvent(VendingMachineEvent<InputObject> inputObjectVendingMachineEvent) {
        Optional<Coin> coin = classifier.classify(inputObjectVendingMachineEvent.getMessage());
        System.out.println("classifier says"+coin);
        if ( coin.isPresent() ) {
            Coin c = coin.get();
            if ( c.getCurrency().equals(allowedCurrency)) {
                balance += c.getUnits();
                System.out.println("Increased balannce to "+balance+" "+c);
                this.publisher.publishEvent(new VendingMachineEvent<String>(this,"Credit: "+balance));
                return;
            }
            System.out.println("Bad currency");
        }
        this.publisher.publishEvent(new VendingMachineEvent<String>(this,"Invalid input"));
    }

    @Override
    public boolean completeSale(Currency currency, int price) {
        if (currency.equals(allowedCurrency) && price <= balance ) {
            //physically return balance-price
            // or capture for less
            balance = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelSale() {
        balance = 0;
        // physically return coins or cancel auth
        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    Currency getCurrency() {
        return allowedCurrency;
    }
}
