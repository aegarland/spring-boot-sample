package com.aegarland.sample.vending.payment.service;

import com.aegarland.sample.vending.domain.Currency;
import com.aegarland.sample.vending.payment.domain.Coin;
import com.aegarland.sample.vending.payment.domain.InputObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by aeg on 3/2/2016.
 */
@Component
public class InputObjectClassifierImpl implements InputObjectClassifier {

    private final Collection<Coin> coinCatalog;

    public InputObjectClassifierImpl() {
        coinCatalog = new ArrayList<>(6);
        coinCatalog.add(new Coin(3.0,1.1,1.2, Currency.USD, 1));
        coinCatalog.add(new Coin(5.0,2.0,2.0, Currency.USD, 5));
        coinCatalog.add(new Coin(2.0,1.0,1.0, Currency.USD, 10));
        coinCatalog.add(new Coin(7.0,1.7,2.5, Currency.USD, 25));
        coinCatalog.add(new Coin(10.0,1.8,5.0, Currency.USD, 50));

        System.out.println(coinCatalog);
    }

    public InputObjectClassifierImpl(Collection<Coin> coinCatalog) {
        this.coinCatalog = coinCatalog;
    }

    // TODO add additional maching and do more efficiently
    @Override
    public Optional<Coin> classify(final InputObject input) {
        System.out.println("input = "+input);

        return coinCatalog.parallelStream().filter(c->c.getWeight()==input.getWeight()).findAny();
    }

}
